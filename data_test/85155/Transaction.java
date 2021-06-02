public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * bla bla.
     */
    Transaction() {

    }

    /**
     * bla bla.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * bla bla.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * bla bla.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * bla bla.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * bla bla.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * bla bla.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * bla bla.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
