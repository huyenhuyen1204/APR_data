public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    final public static String DEPOSIT = "deposit";
    final public static String WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getWITHDRAW() {
        return WITHDRAW;
    }

    public String getDEPOSIT() {
        return DEPOSIT;
    }
}
