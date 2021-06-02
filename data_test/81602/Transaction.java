public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * do nothing.
     */
    public Transaction(String operation, double amount, double balance) {
        if (amount > 0) {
            this.operation = operation;
            this.amount = amount;
            this.balance = balance;
        }
    }

    /**
     * do nothing.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * do nothing.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * do nothing.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * do nothing.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * do nothing.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
