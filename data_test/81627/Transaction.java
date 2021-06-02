public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAW = "WITHDRAW";

    /**
     * Javadoc Comment.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Javadoc Comment.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Javadoc Comment.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Javadoc Comment.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Javadoc Comment.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Javadoc Comment.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Javadoc Comment.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
