public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /** hello. */
    public Transaction() {}

    /** hello. */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /** hello. */
    public double getAmount() {
        return amount;
    }

    /** hello. */
    public double getBalance() {
        return balance;
    }

    /** hello. */
    public String getOperation() {
        return operation;
    }

    /** hello. */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** hello. */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** hello. */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /** hello. */
    @Override
    public String toString() {
        if (operation.equals(DEPOSIT)) {
            return "Nap tien "
                    + "$" + String.format("%.2f", amount)
                    + ". So du luc nay: "
                    + "$" + String.format("%.2f", balance) + ".";
        } else if (operation.equals(WITHDRAW)) {
            return "Rut tien "
                    + "$" + String.format("%.2f", amount)
                    + ". So du luc nay: "
                    + "$" + String.format("%.2f", balance) + ".";
        }
        return null;
    }
}
