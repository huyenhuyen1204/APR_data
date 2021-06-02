public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    final static public String DEPOSIT ="deposit";
    final static public String WITHDRAW="withdraw";

    public Transaction(String operation, double amount, double blance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = blance;
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
