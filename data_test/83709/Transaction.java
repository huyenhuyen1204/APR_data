public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * yay.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * yay.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * yay.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * yay.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * yay.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * yay.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * yay.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
