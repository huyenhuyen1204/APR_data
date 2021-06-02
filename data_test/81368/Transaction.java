public class Transaction {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    private String operation;
    private double amount;
    private double balance;

    /**
     * defaultConstructor.
     */
    public Transaction() {
    }

    /**
     * constructor.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * getOperation.
     * @return operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * setOperation.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * getAmount.
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * setAmount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * getBalance.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setBalance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
