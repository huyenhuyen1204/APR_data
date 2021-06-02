import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {

  private List<Customer> customerList;

  /**
   * Def cons.
   */
  public Bank() {
    customerList = new ArrayList<>();
  }

  /**
   * Read from stream.
   *
   * @param stream is
   */
  public void readCustomerList(InputStream stream) {
    try (Scanner scanner = new Scanner(stream)) {
      Customer temp = null;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        Pattern readCus = Pattern.compile("^([^0-9]+) (\\d+)$", Pattern.CASE_INSENSITIVE);
        Pattern readAcc = Pattern.compile("^(\\d+) (\\w+) ([0-9-.]+)$", Pattern.CASE_INSENSITIVE);
        Matcher checkCus = readCus.matcher(line);
        Matcher checkAcc = readAcc.matcher(line);
        if (checkCus.find()) {
          if (temp != null) {
            customerList.add(temp);
          }
          temp = new Customer(
                  Long.parseLong(checkCus.group(2)), checkCus.group(1));
        } else if (checkAcc.find() && temp != null) {
          String type = checkAcc.group(2);
          if (type.equals(Account.CHECKING)) {
            temp.addAccount(
                    new CheckingAccount(
                            Long.parseLong(checkAcc.group(1)),
                            Double.parseDouble(checkAcc.group(3))));
          } else if (type.equals(Account.SAVINGS)) {
            temp.addAccount(
                    new SavingsAccount(
                            Long.parseLong(checkAcc.group(1)),
                            Double.parseDouble(checkAcc.group(3))));
          }

        }
      }
      if (temp != null) {
        customerList.add(temp);
      }
    }
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * List.
   *
   * @return info
   */
  public String getCustomersInfoByNameOrder() {
    List<Customer> sorted = new ArrayList<>(customerList);
    sorted.sort(Comparator.comparing(o -> o.fullName));
    StringBuilder res = new StringBuilder();
    for (Customer cus : sorted) {
      res.append(cus.getCustomerInfo());
      res.append("\n");
    }
    return res.toString().trim();
  }

  /**
   * List.
   *
   * @return info
   */
  public String getCustomersInfoByIdOrder() {
    List<Customer> sorted = new ArrayList<>(customerList);
    sorted.sort(Comparator.comparingLong(o -> o.idNumber));
    StringBuilder res = new StringBuilder();
    for (Customer cus : sorted) {
      res.append(cus.getCustomerInfo());
      res.append("\n");
    }
    return res.toString().trim();
  }
}
