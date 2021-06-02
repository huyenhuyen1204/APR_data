import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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
    public String getCustomersInfoByNameOrder() {
        List<Customer> tmp = new ArrayList<>(customerList);
        tmp.sort(Comparator.comparing(Customer::getFullName));
        return listToString(tmp);
    }

    /**
     * Functions.
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> tmp = new ArrayList<>(customerList);
        tmp.sort((o1, o2) -> (int) (o1.getIdNumber() - o2.getIdNumber()));
        return listToString(tmp);
    }

    /**
     * Functions.
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Functions.
     */
    private String listToString(List<Customer> list) {
        StringBuilder res = new StringBuilder();
        for (Customer customer : list) {
            res.append(customer.getCustomerInfo());
        }
        return res.toString().trim();
    }
}
