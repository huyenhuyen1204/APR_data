
import java.util.ArrayList;

public class Transaction {
    private String operation;//tên giao dịch
    private double amount;//số tiền giao dịch
    private double balance;//số tiền có trong tài khoản
    
    public static final String DEPOSIT = "deposit";//nạp tiền
    public static final String WITHDRAW = "withdraw";//rút tiền

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
