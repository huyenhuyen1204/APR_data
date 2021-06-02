public class Transaction {

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    private String operation;
    private double amount;
    private double balance;

    /**
     * Loan.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Loan.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Loan.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Loan.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Loan.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Loan.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Loan.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
