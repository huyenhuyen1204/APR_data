import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Customer customer = null;
        try {
            while (reader.ready()) {
                String line = reader.readLine();
                String ar[] = line.split(" ");
                int leng = ar.length;
                if (ar[leng - 1].length() == 9 && isNumeric(ar[leng - 1])) {
                    long id = Long.valueOf(ar[leng - 1]);
                    StringBuilder name = new StringBuilder();
                    for (int i = 0; i < leng - 1; i++) {
                        name.append(ar[i]).append(" ");
                    }
                    if (customer != null) {
                        customerList.add(customer);
                    }
                    customer = new Customer(id, name.toString().trim());
                }
                Account account = null;
                if (leng != 3) {
                    continue;
                }
                long accountNumber = Long.valueOf(ar[0]);
                double banlance = Double.valueOf(ar[2]);
                if (ar[1].equals(Account.SAVINGS)) {
                    account = new SavingsAccount(accountNumber, banlance);
                } else if (ar[1].equals(Account.CHECKING)) {
                    account = new CheckingAccount(accountNumber, banlance);
                }
                if (account != null)
                    customer.addAccount(account);

            }
            if (customer != null) {
                customerList.add(customer);
            }
        } catch (IOException e) {
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public String getCustomersInfoByNameOrder() {
        List<Customer> tmp = new ArrayList<>(customerList);
        tmp.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return listToString(tmp);
    }

    public String getCustomersInfoByIdOrder() {
        List<Customer> tmp = new ArrayList<>(customerList);
        tmp.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int) (o1.getIdNumber() - o2.getIdNumber());
            }
        });
        return listToString(tmp);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    private String listToString(List<Customer> list) {
        StringBuilder res = new StringBuilder();
        for (Customer customer : list) {
            res.append(customer.getCustomerInfo());
        }
        return res.toString();
    }
}
