public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /** Mai Huy. */
    public Transaction() {

    }

    /** Mai Huy. */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /** Mai Huy. */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Mai Huy. */
    public double getAmount() {
        return this.amount;
    }

    /** Mai Huy. */
    public String getOperation() {
        return this.operation;
    }

    /** Mai Huy. */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /** Mai Huy. */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** Mai Huy. */
    public double getBalance() {
        return this.balance;
    }

}
