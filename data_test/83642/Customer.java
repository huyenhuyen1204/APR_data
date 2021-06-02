import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName = "";
    private List<Account> accountList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Customer() {}

    /**
     * Full parameters constructor.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Getter for ID number.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * Setter for ID number.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Getter for full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Setter for full name.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Getter for account list.
     */
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Get info of customer.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }

    /**
     * Add 1 account.
     */
    public void addAccount(Account account) {
        int check = 0;
        for (Account acc : accountList) {
            if (account.equals(acc)) {
                check += 1;
            }
        }
        if (check == 0) {
            accountList.add(account);
        }
    }

    /**
     * Remove 1 account.
     */
    public void removeAccount(Account account) {
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i).equals(account)) {
                accountList.remove(i);
                return;
            }
        }
    }
}