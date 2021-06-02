import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Read Customer List.
     */
    public void readCustomerList(InputStream inputStream) {
        try {
            InputStreamReader reader = new InputStreamReader(inputStream);
            int x = 0;
            String data = "";
            while (true) {
                x = reader.read();
                if (x == -1) {
                    break;
                }
                data = data + (char) x;
            }
            String[] lines = data.split("\n");
            Customer currentCustomer = new Customer();
            for (String line: lines) {
                if (line.charAt(0) >= '0' && line.charAt(0) <= '9') {
                    String[] idTypeBalance = line.split(" ");
                    long id = Long.parseLong(idTypeBalance[0]);
                    double balance = Double.parseDouble(idTypeBalance[2]);
                    if (idTypeBalance[1].equals("SAVINGS")) {
                        currentCustomer.addAccount(new SavingsAccount(id, balance));
                    } else {
                        currentCustomer.addAccount(new CheckingAccount(id, balance));
                    }
                } else {
                    String[] splitLine = line.split(" ");
                    String name = "";
                    for (int i = 0; i < splitLine.length - 1; i++) {
                        name = name + splitLine[i];
                        if (i < splitLine.length - 2) {
                            name = name + " ";
                        }
                    }
                    long id = Long.parseLong(splitLine[splitLine.length - 1]);
                    currentCustomer = new Customer(id, name);
                    customerList.add(currentCustomer);
                }
            }
        } catch(Exception ex) {
            System.out.println("Exception1");
        }
    }

    /**
     * sort customer list by id.
     */
    private void sortById() {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                if (customerList.get(i).getIdNumber() > customerList.get(j).getIdNumber()) {
                    Customer temp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, temp);
                }
            }
        }
    }

    /**
     * sort customer list by name.
     */
    private void sortByName() {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                if (customerList.get(i).getFullName()
                        .compareTo(customerList.get(j).getFullName()) > 0) {
                    Customer temp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, temp);
                }
            }
        }
    }

    /**
     * get customer info.
     */
    public String getCustomersInfoByIdOrder() {
        String res = "";
        sortById();
        for (int i = 0; i < customerList.size(); i++) {
            res = res + customerList.get(i).getCustomerInfo();
            if (i < customerList.size() - 1) {
                res = res + "\n";
            }
        }
        return res;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * get customer info.
     */
    public String getCustomersInfoByNameOrder() {
        String res = "";
        sortByName();
        for (int i = 0; i < customerList.size(); i++) {
            res = res + customerList.get(i).getCustomerInfo();
            if (i < customerList.size() - 1) {
                res = res + "\n";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*try {

            InputStream st = new FileInputStream("src/st.txt");
            Bank bank = new Bank();
            bank.readCustomerList(st);
            System.out.println(bank.getCustomersInfoByIdOrder());
        }
        catch(Exception ex) {
            System.out.println("Exception");
        }*/

    }
}
