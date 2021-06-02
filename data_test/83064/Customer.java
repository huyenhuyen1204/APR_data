//package banking;

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

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * return all info customer.
     */
    public String getCustomerInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Số CMND: ")
                .append(idNumber)
                .append(". Họ tên: ")
                .append(fullName)
                .append(".\n");
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return customer.idNumber == idNumber;
        }
        return false;
    }
}
