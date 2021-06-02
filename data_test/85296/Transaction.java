public class Transaction {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    private String operation;
    private double amount;
    private double balance;

    /**
     * constructor.
     *
     * @param operation o.
     * @param amount    a.
     * @param balance   b.
     */
    public Transaction(String operation, double amount, double balance) {
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
