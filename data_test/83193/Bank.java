import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 * Created by CCNE on 03/12/2020.
 */

public class Bank {
    private List<Customer> customerList;

    /**
     * javadoc.
     */
    public void readCustomerList(InputStream inputStream) {
        customerList = new ArrayList<Customer>();
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            Customer customer = null;
            while (br.ready()) {
                String line = br.readLine();
                String[] word = line.split(" ");
                if (Character.isDigit(word[0].charAt(0))) {
                    Integer id = Integer.parseInt(word[0]);
                    Double money = Double.parseDouble(word[2]);
                    Account account;
                    if (word[1].compareTo(Account.CHECKING) == 0) {
                        CheckingAccount checkingAccount = new CheckingAccount(id, money);
                        account = (Account) checkingAccount;
                    } else {
                        SavingsAccount savingsAccount = new SavingsAccount(id, money);
                        account = (Account) savingsAccount;
                    }
                    customer.addAccount(account);

                } else {
                    int len = word.length;
                    String name = "";
                    for (int i = 0; i < len - 1; ++i) {
                        name += word[i];
                        if (i < len - 1 - 1) {
                            name = name + " ";
                        }
                    }
                    Integer id = Integer.parseInt(word[len - 1]);
                    customer = new Customer(id, name);
                    customerList.add(customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * javadoc.
     */
    public String getCustomersInfoByNameOrder() {
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int cmp = o1.getFullName().compareTo(o2.getFullName());
                if (cmp == 0) {
                    return (o1.getIdNumber() > o2.getIdNumber() ? 1 : -1);
                } else {
                    return cmp;
                }
            }
        });

        String ret = "";
        for (Customer customer : customerList) {
            ret += customer.getCustomerInfo() + "\n";
        }
        return ret;
    }

    /**
     * javadoc.
     */
    public String getCustomersInfoByIdOrder() {
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.getIdNumber() == o2.getIdNumber()) {
                    return o1.getFullName().compareTo(o2.getFullName());
                } else {
                    return (o1.getIdNumber() > o2.getIdNumber() ? 1 : -1);
                }
            }
        });

        String ret = "";
        for (Customer customer : customerList) {
            ret += customer.getCustomerInfo() + "\n";
        }
        return ret;
    }

    /**
     * javadoc.
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
 