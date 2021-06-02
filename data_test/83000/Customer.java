import java.util.ArrayList;
import java.util.List;

public class Customer {

    protected long idNumber;
    protected String fullName;

    private final List<Account> accountList;

    public Customer() {
        accountList = new ArrayList<>();
    }

    /**
     * Customer.
     * @param idNumber  i
     * @param fullName f
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        accountList = new ArrayList<>();
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

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s",
                idNumber, fullName);
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}
