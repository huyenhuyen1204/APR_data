import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * Yes.
     */
    public Customer() {

    }

    /**
     * Yes.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Yes.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + this.idNumber + ". Họ tên: " + this.fullName + ".";
    }

    /**
     * Yes.
     */
    public void addAccount(Account newAcc) {
        for (Account account : accountList) {
            if (account.equals(newAcc)) {
                return;
            }
        }
        accountList.add(newAcc);
    }

    /**
     * Yes.
     */
    public void removeAccount(Account acc) {
        for (int i = 0; i < accountList.size(); ++i) {
            if (acc.equals(accountList.get(i))) {
                accountList.remove(i);
                --i;
            }
        }
    }

    /**
     * Yes.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * Yes.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Yes.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Yes.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Yes.
     */
    public List<Account> getAccountList() {
        return accountList;
    }
}
 