/**
 * Created by CCNE on 05/11/2019.
 */
public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public final String DEPOSIT="deposit";
    public final  String WITHDRAW="withdraw";
    public  Transaction()   {};
    public Transaction(String operation, double amount, double balance) {
        this.amount=amount;
        this.balance = balance;
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
