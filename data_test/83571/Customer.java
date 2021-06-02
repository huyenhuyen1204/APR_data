import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Customer() {

    }

    /**
     * Constructor 2.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Get customer info.
     */
    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s.",
                idNumber,
                fullName);
    }

    /**
     * Add account to account list.
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Remove account from list.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}
