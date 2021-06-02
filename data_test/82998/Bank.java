import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream inputStream) {
        StringBuilder file = new StringBuilder();
        int data = 0;
        while(data != -1) {
            try {
                data = inputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.append((char) data);
        }
        file.deleteCharAt(file.length() - 1);
        String string = file.toString();
        String[] lines = string.split("\\r?\\n");
        Customer customer = null;
        for (String line: lines) {
            if (Character.isAlphabetic(line.charAt(0))) {   // New customer
                customer = getCustomerFromFile(line);
                customerList.add(customer);
            } else {
                Account account = getAccountForCustomer(line);
                assert customer != null;
                customer.addAccount(account);
            }
        }
    }

    public Account getAccountForCustomer(String line) {
        line = line.trim();
        String[] words = line.split("\\s+");
        long accountNumber = Long.parseLong(words[0]);
        String accountType = words[1];
        double balance = Double.parseDouble(words[2]);
        if (accountType.equals(Account.CHECKING)) {
            return new CheckingAccount(accountNumber, balance);
        } else {
            return new SavingsAccount(accountNumber, balance);
        }
    }

    public Customer getCustomerFromFile(String line) {
        line = line.trim();
        String[] words = line.split("\\s+");
        String id = words[words.length - 1];
        String name = line.replace(id, "");
        name = name.trim();    id = id.trim();
        long CMND = Long.parseLong(id);
        return new Customer(CMND, name);
    }

    public String getCustomersInfoByNameOrder() {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                if (customerList.get(i).fullName.compareTo(customerList.get(j).fullName) > 0) {
                    Customer temp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, temp);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Customer customer: customerList) {
            ans.append(customer.getCustomerInfo());
            ans.append("\n");
        }
        return String.valueOf(ans);
    }

    public String getCustomersInfoByIdOrder() {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                if (customerList.get(i).idNumber > customerList.get(j).idNumber) {
                    Customer temp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, temp);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Customer customer: customerList) {
            ans.append(customer.getCustomerInfo());
            ans.append("\n");
        }
        return String.valueOf(ans);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
