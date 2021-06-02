import java.util.ArrayList;
import java.util.List;

/**
 * class Customer.
 */
public class Customer {

    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * constructor.
     */
    public Customer() {

    }

    /**
     * constructor.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * getter.
     * @return .
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber
                + ". Họ tên: " + fullName + ".";
    }

    /**
     * addAccount.
     * @param account .
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * removeAccount.
     * @param account .
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    /**
     * getter.
     * @return .
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * setter.
     * @param idNumber .
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * getter.
     * @return .
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * setter.
     * @param fullName .
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * getter.
     * @return .
     */
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * setter.
     * @param accountList .
     */
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
