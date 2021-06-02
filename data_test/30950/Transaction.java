public class Transaction {
    private String operation;
    private double amount, balance;
    public static final String DEPOSIT = "deposit", WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance){
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public void setOperation(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
