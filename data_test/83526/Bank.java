import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Take all customer from input and store in customer list.
     */
    public void readCustomerList(InputStream input) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(input,
                    StandardCharsets.UTF_8));
            String temp;
            int customerIndex = -1;
            while (br.ready()) {
                temp = br.readLine().trim();
                if (Character.isAlphabetic(temp.charAt(0))) {
                    Customer newCustomer = new Customer();
                    customerIndex++;
                    String[] content = temp.split("\\s+");
                    String idNumber = content[content.length - 1];
                    newCustomer.setIdNumber(Long.parseLong(idNumber));
                    newCustomer.setFullName(temp.replace(idNumber, "").trim());
                    customerList.add(newCustomer);
                } else {
                    String[] content = temp.split("\\s+");
                    long accountNumber = Long.parseLong(content[0]);
                    String accountType = content[1];
                    double balance = Double.parseDouble(content[2]);
                    Account newAccount;
                    if (accountType.equals(Account.CHECKING)) {
                        newAccount = new CheckingAccount(accountNumber, balance);
                    } else {
                        newAccount = new SavingsAccount(accountNumber, balance);
                    }
                    customerList.get(customerIndex).addAccount(newAccount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return all customer sorted by name.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        StringBuilder res = new StringBuilder();
        for (Customer customer : customerList) {
            res.append(customer.getCustomerInfo());
            res.append("\n");
        }
        return res.toString();
    }

    /**
     * Return all customer sorted by id.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return Long.compare(o1.getIdNumber(), o2.getIdNumber());
            }
        });
        StringBuilder res = new StringBuilder();
        for (Customer customer : customerList) {
            res.append(customer.getCustomerInfo());
            res.append("\n");
        }
        return res.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
