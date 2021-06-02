import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Getter for customer list.
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * cmt.
     */
    public int checkNumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                count++;
            }
        }
        if (count > 0) {
            return 0;
        }
        return 1;
    }

    /**
     * Read customer list from file.
     */
    public void readCustomerList(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line;
        Customer customer = new Customer();
        while (true) {
            try {
                line = reader.readLine();
                if (line != null) {
                    String[] words = line.split(" ");
                    if (checkNumber(words[0]) == 1) {
                        if (words[1].equals("CHECKING")) {
                            Account account = new CheckingAccount(Long.parseLong(words[0]),
                                    Double.parseDouble(words[2]));
                            customer.addAccount(account);
                        } else {
                            Account account = new SavingsAccount(Long.parseLong(words[0]),
                                    Double.parseDouble(words[2]));
                            customer.addAccount(account);
                        }
                    } else {
                        String name = "";
                        for (int i = 0; i < words.length - 2; i++) {
                            name = name + words[i] + " ";
                        }
                        name += words[words.length - 2];
                        customer = new Customer(Long.parseLong(words[words.length - 1]), name);
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
     * Order by name.
     */
    public String getCustomersInfoByNameOrder() {
        for (int i = 0; i < customerList.size(); ++i) {
            for (int j = i + 1; j < customerList.size(); ++j) {
                if (customerList.get(i).getFullName()
                        .compareTo(customerList.get(j).getFullName()) > 0) {
                    Collections.swap(customerList, i, j);
                }
            }
        }
        String res = "";
        for (int i = 0; i < customerList.size(); ++i) {
            res += customerList.get(i).getCustomerInfo();
            if (i != customerList.size() - 1) {
                res += "\n";
            }
        }
        return res;
    }

    /**
     * Order by id.
     */
    public String getCustomersInfoByIdOrder() {
        for (int i = 0; i < customerList.size(); ++i) {
            for (int j = i + 1; j < customerList.size(); ++j) {
                if (customerList.get(i).getIdNumber() > customerList.get(j).getIdNumber()) {
                    Collections.swap(customerList, i, j);
                }
            }
        }
        String res = "";
        for (int i = 0; i < customerList.size(); ++i) {
            res += customerList.get(i).getCustomerInfo();
            if (i != customerList.size() - 1) {
                res += "\n";
            }
        }
        return res;
    }
}