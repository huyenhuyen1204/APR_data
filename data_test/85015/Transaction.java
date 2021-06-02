public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * constructor.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * getter.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * setter.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * getter.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * setter.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * getter.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setter.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
