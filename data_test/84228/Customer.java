import java.util.List;
import java.util.ArrayList;

public class Customer {
    private long idNumber;
    private String fullName = "";
    private List<Account> accountList = new ArrayList<>();

    public Customer() {

    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        String res = "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
        return res;
    }

    public void addAccount(Account a) {
        for (Account account : accountList) {
            if (account.equals(a)) {
                return;
            }
        }
        accountList.add(a);
    }

    public void removeAccount(Account a) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).equals(a)) {
                accountList.remove(i);
                return;
            }
        }
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
