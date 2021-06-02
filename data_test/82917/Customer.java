import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer {

  private long idNumber;
  private String fullName;
  private final List<Account> accountList;

  /**
   * ldkjflkasjf.
   * @param idNumber d
   * @param fullName dk
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    accountList = new ArrayList<>();
  }

  public Customer() {
    this(0, "");
  }

  public String getCustomerInfo() {
    return String.format("Số CMND: %s. Họ tên: %s.", idNumber, fullName);
  }

  public long getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void addAccount(Account account) {
    accountList.add(account);
  }

  public void removeAccount(Account account) {
    accountList.remove(account);
  }

  public List<Account> getAccountList() {
    return accountList;
  }

  public static final Comparator<Customer> NAME_COMPARATOR = (o1, o2) -> o1.fullName
      .compareTo(o2.fullName);
  public static final Comparator<Customer> ID_COMPARATOR = (o1, o2) -> Long
      .compare(o1.idNumber, o2.idNumber);
}
