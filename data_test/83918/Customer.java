import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {
    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Javadoc.
     */
    public String getCustomerInfo() {
        String result = "";
        result += idNumber + " " + fullName + '\n';
        return result;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.removeIf(temp -> temp.equals(account));
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
