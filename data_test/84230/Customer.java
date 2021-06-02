import java.util.List;
import java.util.ArrayList;

public class Customer {
    private long idNumber;
    private String fullName = "";
    private List<Account> accountList = new ArrayList<>();

    public Customer() {

    }

    /**
     * tt.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * tt.
     */
    public String getCustomerInfo() {
        String res = "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
        return res;
    }

    /**
     * tt.
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
     * tt.
     */
    public void removeAccount(Account a) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).equals(a)) {
                accountList.remove(i);
                return;
            }
        }
    }

    /**
     * tt.
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * tt.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * tt.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * tt.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * tt.
     */
    public List<Account> getAccountList() {
        return accountList;
    }
}
