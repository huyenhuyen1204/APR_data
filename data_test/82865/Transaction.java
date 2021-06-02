public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * gan tham so.
     */

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

}
