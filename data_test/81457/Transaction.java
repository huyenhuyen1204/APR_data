public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "";
    public static final String WITHDRAW = "";

    /**1.*/
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**1.*/
    public String getOperation() {
        return operation;
    }

    /**1.*/
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**1.*/
    public double getAmount() {
        return amount;
    }

    /**1.*/
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**1.*/
    public double getBalance() {
        return balance;
    }

    /**1.*/
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
