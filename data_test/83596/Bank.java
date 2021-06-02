import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Functions.
     */
    public void readCustomerList(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Customer customer = null;
        try {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] arr = line.split(" ");
                int len = arr.length;
                if (arr[len - 1].length() == 9 && isNumeric(arr[len - 1])) {
                    long id = Long.parseLong(arr[len - 1]);
                    StringBuilder name = new StringBuilder();
                    for (int i = 0; i < len - 1; i++) {
                        name.append(arr[i]).append(" ");
                    }
                    if (customer != null) {
                        customerList.add(customer);
                    }
                    customer = new Customer(id, name.toString().trim());
                }
                Account account = null;
                if (len != 3) {
                    continue;
                }
                long accountNumber = Long.parseLong(arr[0]);
                double banlance = Double.parseDouble(arr[2]);
                if (arr[1].equals(Account.SAVINGS)) {
                    account = new SavingsAccount(accountNumber, banlance);
                } else if (arr[1].equals(Account.CHECKING)) {
                    account = new CheckingAccount(accountNumber, banlance);
                }
                if (account != null) {
                    assert customer != null;
                    customer.addAccount(account);
                }

            }
            if (customer != null) {
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Functions.
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> list = afterSort("id");
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : list) {
            stringBuilder.append(customer.getCustomerInfo() + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Functions.
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> list = afterSort("name");
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : list) {
            stringBuilder.append(customer.getCustomerInfo() + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Functions.
     */
    private List<Customer> afterSort(String string) {
        List<Customer> list = customerList;
        Comparator<Customer> rankOrder;
        if (string.equals("id")) {
            rankOrder = Comparator.comparing(Customer::getIdNumber);
        } else {
            rankOrder = Comparator.comparing(Customer::getFullName);
        }
        list.sort(rankOrder);
        return list;
    }

    /**
     * Functions.
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
