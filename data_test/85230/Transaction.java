public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final  String DEPOSIT = "deposit";
    public static final  String WITHDRAW = "withdraw";

    public  Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public String getOperation() {
        return operation;
    }

    public double getBalance() {
        return balance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
