import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by CCNE on 02/12/2020.
 */
public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public static Comparator<Customer> ID_ORDER = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.getIdNumber() < o2.getIdNumber()) {
                return -1;
            } else if (o1.getIdNumber() > o2.getIdNumber()) {
                return 1;
            }
            return 0;
        }
    };

    public static Comparator<Customer> NAME_ORDER = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            for (int i = 0; i < Math.min(o1.getFullName().length(),
                    o2.getFullName().length()); i++) {
                int cmp = o1.getFullName().charAt(i) - o2.getFullName().charAt(i);
                if (cmp < 0) {
                    return -1;
                }
                if (cmp > 0) {
                    return 1;
                }
            }
            return 0;
        }
    };

    public Customer() {
    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
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
 