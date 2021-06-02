import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private List<Customer> customerList = new ArrayList<>();

    /**
     * Read Customer List from {@code source}.
     */
    public void readCustomerList(InputStream source) {
        Scanner scanner = new Scanner(source);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int digitIndex = getFirstDigitIndex(line);
            if (digitIndex == 0) {
                customerList.get(customerList.size() - 1).addAccount(createAccount(line));
            } else {
                customerList.add(createCustomer(line));
            }
        }
    }

    private Customer createCustomer(String customerInfo) {
        int split = customerInfo.lastIndexOf(' ');
        long idNumber = Long.parseLong(customerInfo.substring(split + 1));
        return new Customer(idNumber, customerInfo.substring(0, split));
    }

    private Account createAccount(String accountInfo) {
        String[] info = accountInfo.split(" ");
        long accountNumber = Long.parseLong(info[0]);
        double balance = Double.parseDouble(info[2]);
        if (info[1].equals(Account.CHECKING))
            return new CheckingAccount(accountNumber, balance);
        return new SavingsAccount(accountNumber, balance);
    }

    private int getFirstDigitIndex(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get customers' info by name order.
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> customersByNameOrder = new ArrayList<>(customerList);
        customersByNameOrder.sort(
            (o1, o2) -> o1.getFullName().compareToIgnoreCase(o2.getFullName()));
        return getCustomersInfo(customersByNameOrder);
    }

    /**
     * Get customers' info by ID order.
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> customersByIdOrder = new ArrayList<>(customerList);
        customersByIdOrder.sort(Comparator.comparingLong(Customer::getIdNumber));
        return getCustomersInfo(customersByIdOrder);
    }

    private String getCustomersInfo(List<Customer> customers) {
        StringBuilder customersInfo = new StringBuilder();
        customers.forEach(n -> customersInfo.append("\n").append(n.getCustomerInfo()));
        customersInfo.deleteCharAt(0);
        return customersInfo.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}

