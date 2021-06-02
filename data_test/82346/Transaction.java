public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "gui";
    public static final String WITHDRAW = "rut";

    /**
     * contructor.
     */
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

    @Override
    public String toString() {
        if (operation.equals("gui")) {
            return "Nap tien $" + String.format("%.2f", amount) + ". So du luc nay: $"
                    + String.format("%.2f", balance) + ".";
        } else {
            return "Rut tien $" + String.format("%.2f", amount) + ". So du luc nay: $"
                    + String.format("%.2f", balance) + ".";
        }
    }
}
