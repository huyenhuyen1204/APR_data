import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {

  private final List<Customer> customerList = new ArrayList<>();

  private static boolean isCustomerInfoLine(String line) {
    return Character.isAlphabetic(line.toCharArray()[0]);
  }

  public void readCustomerList(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    Customer customer = null;
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (isCustomerInfoLine(line)) {
        String id = line.substring(line.length() - 9);
        String name = line.substring(0, line.length() - 10);
        long idNumber = Long.parseLong(id);
        if (customer != null) {
          customerList.add(customer);
        }
        customer = new Customer(idNumber, name);
      } else {
        assert (customer != null);
        String[] tokens = line.split("\\s+");
        assert (tokens.length == 3);
        long accountNumber = Long.parseLong(tokens[0]);
        double amount = Double.parseDouble(tokens[2]);
        if (tokens[1].equals(Account.CHECKING)) {
          customer.addAccount(new CheckingAccount(accountNumber, amount));
        } else if (tokens[1].equals(Account.SAVINGS)) {
          customer.addAccount(new SavingsAccount(accountNumber, amount));
        }
      }
    }
    if (customer != null) {
      customerList.add(customer);
    }
  }

  private String getCustomerInfoSorted(Comparator<Customer> comparator) {
    List<Customer> c = new ArrayList<>(customerList);
    c.sort(comparator);
    StringBuilder sb = new StringBuilder();
    c.forEach(customer -> sb.append(customer.getCustomerInfo()).append('\n'));
    return sb.toString();
  }

  public String getCustomersInfoByIdOrder() {
    return getCustomerInfoSorted(Customer.ID_COMPARATOR);
  }

  public String getCustomersInfoByNameOrder() {
    return getCustomerInfoSorted(Customer.NAME_COMPARATOR);
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }
}
