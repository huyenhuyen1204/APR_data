import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

/**
 * class Bank.
 */
public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * readCustomerList.
     * @param input .
     */
    public void readCustomerList(InputStream input) {
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(" ");

            if (words.length != 3) {
                String name = String.join(" ",
                        Arrays.copyOfRange(words, 0, words.length - 1));
                long id = Long.parseLong(words[words.length - 1]);
                customerList.add(new Customer(id, name));
            } else {

                long accountNumber = Long.parseLong(words[0]);
                String accountType = words[1];
                double accountBalance = Double.parseDouble(words[2]);

                if (accountType.equals(Account.CHECKING)) {
                    customerList.get(customerList.size() - 1)
                            .addAccount(new CheckingAccount(accountNumber, accountBalance));
                } else if (accountType.equals(Account.SAVINGS)) {
                    customerList.get(customerList.size() - 1)
                            .addAccount(new SavingsAccount(accountNumber, accountBalance));
                }
            }
        }
    }

    /**
     * getter.
     * @return .
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> nameOrder = new ArrayList<Customer>(customerList);
        nameOrder.sort(new Comparator<Customer>() {
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });

        StringBuilder result = new StringBuilder();
        for (Customer customer : nameOrder) {
            result.append(customer.getCustomerInfo()).append("\n");
        }
        return result.toString().trim();
    }

    /**
     * getter.
     * @return .
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> idOrder = new ArrayList<Customer>(customerList);
        idOrder.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int) (o1.getIdNumber() - o2.getIdNumber());
            }
        });

        StringBuilder result = new StringBuilder();
        for (Customer customer : idOrder) {
            result.append(customer.getCustomerInfo()).append("\n");
        }
        return result.toString().trim();
    }

    /**
     * getter.
     * @return .
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
