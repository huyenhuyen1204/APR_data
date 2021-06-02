import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * cmt.
     */
    public static void main(String[] args) throws FileNotFoundException {

        Bank bank = new Bank();
        bank.readCustomerList(new FileInputStream("src/test.txt"));
        List<Customer> customers = bank.getCustomerList();
        customers.get(0).getAccountList().get(0).deposit(2000.00);
        customers.get(0).getAccountList().get(0).withdraw(500.0);
        customers.get(0).getAccountList().get(0).withdraw(300.0);
        System.out.println(customers.get(0).getAccountList().get(0).getTransactionHistory());
    }

    /**
     * cmt.
     */
    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * cmt.
     */
    public void readCustomerList(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        Customer customer = new Customer();
        while (true) {
            try {
                if (((line = reader.readLine()) != null)) {
                    String[] ss = line.split(" ");
                    if (isNumber(ss[0])) {
                        if (ss[1].equals("CHECKING")) {
                            Account account = new CheckingAccount(Long.parseLong(ss[0]),
                                    Double.parseDouble(ss[2]));
                            customer.addAccount(account);
                        } else {
                            Account account = new SavingsAccount(Long.parseLong(ss[0]),
                                    Double.parseDouble(ss[2]));
                            customer.addAccount(account);
                        }
                    } else {
                        String name = "";
                        for (int i = 0; i < ss.length - 2; ++i) {
                            name = name + ss[i] + " ";
                        }
                        name += ss[ss.length - 2];
                        customer = new Customer(name, Long.parseLong(ss[ss.length - 1]));
                        customerList.add(customer);
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * cmt.
     */
    public String getCustomersInfoByIdOrder() {
        for (int i = 0; i < customerList.size(); ++i) {
            for (int j = i + 1; j < customerList.size(); ++j) {
                if (customerList.get(i).getIdNumber() > customerList.get(j).getIdNumber()) {
                    Customer swap = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, swap);
                }
            }
        }
        String s = "";
        for (int i = 0; i < customerList.size(); ++i) {
            s = s + customerList.get(i).getCustomerInfo();
            if (i != customerList.size() - 1) {
                s += "\n";
            }
        }
        return s;
    }

    /**
     * cmt.
     */
    public String getCustomersInfoByNameOrder() {
        for (int i = 0; i < customerList.size(); ++i) {
            for (int j = i + 1; j < customerList.size(); ++j) {
                if (customerList.get(i).getFullName()
                        .compareTo(customerList.get(j).getFullName()) > 0) {
                    Customer swap = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, swap);
                }
            }
        }
        String s = "";
        for (int i = 0; i < customerList.size(); ++i) {
            s = s + customerList.get(i).getCustomerInfo();
            if (i != customerList.size() - 1) {
                s += "\n";
            }
        }
        return s;
    }
}
