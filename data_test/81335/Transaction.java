public class Transaction {
    public static final String in = "DEPOSIT";
    public static final String out = "WITHDRAW";
    private String operation;
    private double amount;
    private double balance;

    /**
     * .
     *
     * @param operation .
     * @param amount    .
     * @param balance   .
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * .
     *
     * @return .
     */
    public String getOperation() {
        return operation;
    }

    /**
     * .
     *
     * @param operation .
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * .
     *
     * @return .
     */
    public double getAmount() {
        return amount;
    }

    /**
     * .
     *
     * @param amount .
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * .
     *
     * @return .
     */
    public double getBalance() {
        return balance;
    }

    /**
     * .
     *
     * @param balance .
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
