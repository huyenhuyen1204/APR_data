import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Javadoc.
     */
    public void readCustomerList(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        Customer tempCustomer;
        while (scanner.hasNext()) {
            String lineData = "";
            lineData = scanner.nextLine();
            if (isPersonInfoLine(lineData)) {
                tempCustomer = new Customer();
                int i = 0;
                String name = "";
                long id = 0;
                while (!isDigit(lineData.charAt(i))) {
                    name += lineData.charAt(i);
                    i++;
                }
                name = name.trim();
                id = Long.parseLong(lineData.substring(i));
                tempCustomer.setFullName(name);
                tempCustomer.setIdNumber(id);
                customerList.add(tempCustomer);
            } else {
                tempCustomer = customerList.get(customerList.size() - 1);
                Scanner scanner1 = new Scanner(lineData);
                long accountNumber = scanner1.nextLong();
                String type = scanner1.next();
                double balance = scanner1.nextDouble();
                if (type.equals("CHECKING")) {
                    CheckingAccount tempAccount = new CheckingAccount(accountNumber, balance);
                    tempCustomer.addAccount(tempAccount);
                } else if (type.equals("SAVINGS")) {
                    SavingsAccount tempAccount = new SavingsAccount(accountNumber, balance);
                    tempCustomer.addAccount(tempAccount);
                }
            }
        }
    }

    /**
     * Javadoc.
     */
    private boolean isPersonInfoLine(String str) {
        if (isDigit(str.charAt(0))) {
            return false;
        }
        return true;
    }

    /**
     * Javadoc.
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> list = new ArrayList<>(customerList);
        String result = "";
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getFullName().compareTo(list.get(j).getFullName()) > 0) {
                    Customer temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (Customer customer : list) {
            result += "Số CMND: " + customer.getIdNumber() + ". Họ tên: " + customer.getFullName() + ".\n";
        }
        return result;
    }

    /**
     * Javadoc.
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> list = new ArrayList<>(customerList);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getIdNumber() > list.get(j).getIdNumber()) {
                    Customer temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (Customer customer : list) {
            result += "Số CMND: " + customer.getIdNumber() + ". Họ tên: " + customer.getFullName() + ".\n";
        }
        return result;
    }
}
