/**
 * The type Transaction.
 */
public class Transaction {

    private String operation;
    private double amount;
    private double balance;
    /**
     * The constant DEPOSIT.
     */
    public static final String DEPOSIT = "deposit";
    /**
     * The constant WITHDRAW.
     */
    public static final String WITHDRAW = "withdraw";

    /**
     * Gets operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets operation.
     *
     * @param operation the operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Instantiates a new Transaction.
     *
     * @param operation the operation
     * @param amount    the amount
     * @param balance   the balance
     */
    public Transaction(String operation, double amount, double balance) {
        this.balance = balance;
        this.operation = operation;
        this.amount = amount;
    }


}
