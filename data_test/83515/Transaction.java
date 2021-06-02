public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * jvbf.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * jvbf.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * jvbf.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * jvbf.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * jvbf.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * jvbf.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * jvbf.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}