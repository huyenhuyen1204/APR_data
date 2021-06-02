import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<Customer>();

    /**
     * control.
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
     * control.
     */
    public void readCustomerList(InputStream inputStream) {
        //Creating an InputStream object
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        Customer customer = new Customer();
        while (true) {
            try {
                if (((line = reader.readLine()) != null)) {
                    String[] tmp = line.split(" ");
                    if (isNumber(tmp[0])) {
                        if (tmp[1].equals("CHECKING")) {
                            Account account = new CheckingAccount(Long.parseLong(tmp[0]),
                                    Double.parseDouble(tmp[2]));
                            customer.addAccount(account);
                        } else {
                            Account account = new SavingsAccount(Long.parseLong(tmp[0]),
                                    Double.parseDouble(tmp[2]));
                            customer.addAccount(account);
                        }
                    } else {
                        String name = "";
                        for (int i = 0; i < tmp.length - 2; ++i) {
                            name = name + tmp[i] + " ";
                        }
                        name += tmp[tmp.length - 2];
                        customer = new Customer(Long.parseLong(tmp[tmp.length - 1]), name);
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

    /**
     * control.
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * control.
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
            if (i < customerList.size() - 1) {
                s += "\n";
            }
        }
        return s;
    }

    /**
     * control.
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
            if (i < customerList.size() - 1) {
                s += "\n";
            }
        }
        return s;
    }
}
