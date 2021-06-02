public class Transaction {

    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Comment.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Comment.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Comment.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Comment.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Comment.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Comment.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Comment.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Comment.
     */
    public String getInfo() {
        String result = "";
        if (operation.equals(DEPOSIT)) {
            result += "Nap tien $";
        } else {
            result += "Rut tien $";
        }
        result += String.format("%.2f", amount);
        result += ". So du luc nay: $" + String.format("%.2f", balance) + ".";
        return result;
    }

}
