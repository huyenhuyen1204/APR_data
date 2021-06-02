
public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * create construct.
     * @param operation .
     * @param amount .
     * @param balance .
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
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            return String.format("Nap tien $%.2f. So du luc nay: $%.2f.", this.amount, this.balance);
        } else {
            return String.format("Rut tien $%.2f. So du luc nay: $%.2f.", this.amount, this.balance);
        }
    }
}
