
public class Transaction {

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    private String operation;
    private double amount;
    private double balance;

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperation() {
        switch (operation) {
            case "deposit":
                return "Nap tien";
            case "withdraw":
                return "Rut tien";
            default:
                return operation;
        }
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return getOperation() + " "
                + "$" + String.format("%.2f", amount) + ". "
                + "So du luc nay: $" + String.format("%.2f", balance)
                + '.';
    }
}
