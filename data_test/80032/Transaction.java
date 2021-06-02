public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * javadoc.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }


    /**
     * javadoc.
     */
    public String getOperation() {
        return operation;
    }


    /**
     * javadoc.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }


    /**
     * javadoc.
     */
    public double getAmount() {
        return amount;
    }


    /**
     * javadoc.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }


    /**
     * javadoc.
     */
    public double getBalance() {
        return balance;
    }


    /**
     * javadoc.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }


}
