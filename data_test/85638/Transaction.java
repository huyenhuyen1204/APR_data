public class Transaction {
    private double amount;
    private String operation;
    private double balance;
    public static final String WITHDRAW = "withdraw";
    public static final String DEPOSIT = "deposit";

    /**
     * dadasdsadas.
     * @param operation dsadasd.
     * @param amount dasdasd.
     * @param balance baladadasdnce.
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
}
