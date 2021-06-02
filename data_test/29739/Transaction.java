/**
 * Created by CCNE on 29/10/2019.
 */
public class Transaction {
    static final String DEPOSIT = "deposit";
    static final String WITHDRAW = "withdraw";

    private String operation;
    private double amount;
    private double balance;

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