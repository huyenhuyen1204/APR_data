public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }
    public void setOperation(String o) { this.operation = o; }
    public String getOperation() { return operation; }
    public void setAmount(double a) { this.amount = a; }
    public double getAmount() { return amount; }
    public void setBalance(double b) { this.balance = b; }
    public double getBalance() { return balance; }
}
