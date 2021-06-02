

public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    static final public String DEPOSITE = "DEPOSITE";
    static final public String WITHDRAW = "WITHDRAW";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
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

    public static String getDEPOSITE() {
        return DEPOSITE;
    }

    public static String getWITHDRAW() {
        return WITHDRAW;
    }
}
