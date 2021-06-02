import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName = "";
    private List<Account> accountList = new ArrayList<Account>();

    /**
     * control.
     */
    public Customer() {
    }

    /**
     * control.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * control.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * control.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * control.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * control.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * control.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber +
                ". Họ tên:" + fullName + ".";
    }

    /**
     * control.
     */
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * control.
     */
    public void addAccount(Account a) {
        for (Account account : accountList) {
            if (account.equals(a)) {
                return;
            }
        }
        accountList.add(a);
    }

    /**
     * control.
     */
    public void removeAccount(Account a) {
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i).equals(a)) {
                accountList.remove(i);
                return;
            }
        }
    }
}
