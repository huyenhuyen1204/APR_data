/**
 * .
 * @author Nguyen Quyet Thang .
 */
public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * .
     * @param operation .
     * @param amount .
     * @param balance .
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * .
     * @return .
     */
    public String getOperation() {
        return operation;
    }

    /**
     * .
     * @param operation .
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * .
     * @return .
     */
    public double getAmount() {
        return amount;
    }

    /**
     * .
     * @param amount .
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * .
     * @return .
     */
    public double getBalance() {
        return balance;
    }

    /**
     * .
     * @param balance .
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
