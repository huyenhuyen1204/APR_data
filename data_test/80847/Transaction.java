public class Transaction {

    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * .
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * .
     */
    public double getAmount() {
        return amount;
    }

    /**
     * .
     */
    public double getBalance() {
        return balance;
    }

    /**
     * .
     */
    public String getOperation() {
        return operation;
    }

    /**
     * .
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * .
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * .
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }


}
