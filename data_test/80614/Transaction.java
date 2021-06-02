public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /** binhDang. */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /** binhDang. */
    public String getOperation() {
        return operation;
    }

    /** binhDang. */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /** binhDang. */
    public double getAmount() {
        return amount;
    }

    /** binhDang. */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** binhDang. */
    public double getBalance() {
        return balance;
    }

    /** binhDang. */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
