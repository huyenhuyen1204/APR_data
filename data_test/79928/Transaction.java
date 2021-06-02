public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /** Missing a java doc. */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /** Missing a java doc. */
    public double getAmount() {
        return amount;
    }

    /** Missing a java doc. */
    public double getBalance() {
        return balance;
    }

    /** Missing a java doc. */
    public String getOperation() {
        return operation;
    }

    /** Missing a java doc. */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Missing a java doc. */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** Missing a java doc. */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
