public class Transaction {

    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Phuong thuc khoi tao .
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Ham .
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Ham .
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Ham .
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Ham .
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Ham .
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Ham .
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}