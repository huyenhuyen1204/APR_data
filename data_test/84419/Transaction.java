public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * a.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * a.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * a.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * a.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * a.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * a.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * a.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}