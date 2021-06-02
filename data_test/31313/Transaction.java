

public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    //constructor
    public Transaction(String operation, double amount, double balance) {
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    //setter getter
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
    public String depositToString() {
        return ": Nap tien $" + this.getAmount()+ ".So du luc nay: $" + this.getBalance() +".";
    }
    public String withdrawToString() {
        return ": Rut tien $" + this.getAmount()+ ".So du luc nay: $" + this.getBalance() +".";
    }
}
