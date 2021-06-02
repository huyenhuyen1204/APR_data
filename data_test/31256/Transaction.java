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

    public double round(double x)
    {
        return (double)Math.round(x * 100) / 100;
    }
    public String printaTransaction(){
        if (this.operation.equals("deposit")) return "Nap tien $" + String.format("%.2f" , round(this.amount)) + ". So du luc nay: $" + String.format("%.2f", round(this.balance)) + ".";
        else return "Rut tien $" + String.format("%.2f" , round(this.amount)) + ". So du luc nay: $" + String.format("%.2f", round(this.balance)) + ".";
    }
}
