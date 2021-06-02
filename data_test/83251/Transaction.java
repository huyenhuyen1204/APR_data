import java.text.DecimalFormat;

public class Transaction {
    public static final String deposit = "deposit";
    public static final String withdraw = "withdraw";
    private String operation;
    private double amount;
    private double balance;
    private DecimalFormat f = new DecimalFormat("##.00");

    Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOperation() {
        if (operation.equals(deposit)) {
            return "Nap tien";
        } else {
            return "Rut tien";
        }
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
        return getOperation() + " $" + f.format(getAmount())
                + ". So du luc nay: $" + f.format(getBalance()) + ".";
    }
}