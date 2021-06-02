import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accountList = new ArrayList<>();
    private String fullName = "";
    private long idNumber;

    public Customer() {

    }

    /**
     * Javadoc.
     */
    public Customer(String fullName, long idNumber) {
        this.fullName = fullName;
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Javadoc.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }

    /**
     * Javadoc.
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
     * Javadoc.
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
