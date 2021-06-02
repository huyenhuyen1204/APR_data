import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<Account>();

    public Customer() {
        idNumber = 0;
        fullName = "";
    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
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

    public void addAccount(Account acc) {
        for(int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).equals(acc)) {
                return ;
            }
        }
        accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        for(int i = accountList.size() - 1; i >= 0; i--) {
            if(accountList.get(i).equals(acc)) {
                accountList.remove(i);
            }
        }
    }
}
 