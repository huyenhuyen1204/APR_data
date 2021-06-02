import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 03/12/2020.
 */

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

    /**
     * javadoc.
     */
    public Customer() {
        accountList = new ArrayList<>();
    }

    /**
     * javadoc.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        accountList = new ArrayList<>();
    }

    /**
     * javadoc.
     */
    public String getCustomerInfo() {
        String ret = "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
        return ret;
    }

    /**
     * javadoc.
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
     * javadoc.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    /**
     * javadoc.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * javadoc.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * javadoc.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * javadoc.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * javadoc.
     */
    public List<Account> getAccountList() {
        return accountList;
    }
}
 