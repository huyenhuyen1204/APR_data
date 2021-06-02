import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 03/12/2020.
 */
public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * Functions.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Functions.
     */
    public Customer() {
    }

    /**
     * Functions.
     */
    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s.\n", idNumber, fullName);
    }

    /**
     * Functions.
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Functions.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    /**
     * Functions.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * Functions.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Functions.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Functions.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Functions.
     */
    public List<Account> getAccountList() {
        return accountList;
    }
    /**
     * Functions.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return customer.idNumber == idNumber;
        }
        return false;
    }

}
