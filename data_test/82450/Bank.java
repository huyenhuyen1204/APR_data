import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CCNE on 02/12/2020.
 */
public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream inputStream) {

    }

    public String getCustomersInfoByNameOrder() {
        String result = "";
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
            result += customer.getCustomerInfo() + "\n";
        }
        return result;
    }

    public String getCustomersInfoByIdOrder() {
        String result = "";
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
            result += customer.getCustomerInfo() + "\n";
        }
        return result;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
