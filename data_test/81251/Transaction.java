public class Transaction {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    private String operation;
    private double amount;
    private double balance;

    /**
     * cmt.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * cmt.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * cmt.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * cmt.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * cmt.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * cmt.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * cmt.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
