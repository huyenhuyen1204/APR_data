public class Transaction {

    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Constructor with parameter.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * get operation of the transaction.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * get amount of money in the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * get balance after transacting.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * set operation of the transaction.
     */
    public void setOperation(String operation) {
        if (isValid(operation)) {
            this.operation = operation;
        }
    }

    /**
     * set amount of money in the transaction.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * set balance in the transaction.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * check if a operation is valid.
     */
    public boolean isValid(String op) {
        return (op.equals(DEPOSIT) || op.equals(WITHDRAW));
    }


}
