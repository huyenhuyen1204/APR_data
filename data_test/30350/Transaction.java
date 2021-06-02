public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "recharge";
    public static final String WITHDRAW = "withdrawal";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public Transaction(String operation, double amount) {
        this.operation = operation;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
