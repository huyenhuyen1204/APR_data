import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CCNE on 02/12/2020.
 */
public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            Customer customer = null;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                if ((!line.contains("CHECKING") && !line.contains("SAVINGS"))) {
                    int tmp = line.lastIndexOf(" ");
                    String fullName = line.substring(tmp);
                    long idNumber = Long.parseLong(line.substring(tmp + 1));

                    customer = new Customer(idNumber, fullName);
                    customerList.add(customer);
                } else {
                    String[] parts = line.split(" ");

                    long accountNumber = Long.parseLong(parts[0]);
                    String type = parts[1];
                    double balance = Double.parseDouble(parts[2]);

                    if (type.equals(Account.CHECKING)) {
                        customer.addAccount(new CheckingAccount(accountNumber, balance));
                    } else {
                        customer.addAccount(new SavingsAccount(accountNumber, balance));
                    }
                }
            }
            reader.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCustomersInfoByNameOrder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (Customer.NAME_ORDER.compare(customerList.get(j), customerList.get(i)) < 0) {
                    Customer tmp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, tmp);
                }
            }
        }

        for (Customer customer : customerList) {
            result.append(customer.getCustomerInfo()).append("\n");
        }
        return result.toString().trim();
    }

    public String getCustomersInfoByIdOrder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (Customer.ID_ORDER.compare(customerList.get(j), customerList.get(i)) < 0) {
                    Customer tmp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, tmp);
                }
            }
        }

        for (Customer customer : customerList) {
            result.append(customer.getCustomerInfo()).append("\n");
        }
        return result.toString().trim();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
 