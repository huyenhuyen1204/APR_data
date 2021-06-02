public class Transaction {

    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * iloveyou.
     */
    public Transaction(String operation, double amount, double balance) {

        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * yasuo.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * masteryi.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * zed.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * nasus.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * jax.
     */
    public void setBanlance(double banlance) {
        this.balance = banlance;
    }

    /**
     * khazix.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
