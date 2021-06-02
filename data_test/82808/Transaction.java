public class Transaction {
    private String operation;
    private double amount;
    private double balance;

    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /*Chong chong tre ne Nobita.*/
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /*Chong chong tre ne Nobita.*/
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /*Chong chong tre ne Nobita.*/
    public String getOperation() {
        return operation;
    }

    /*Chong chong tre ne Nobita.*/
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /*Chong chong tre ne Nobita.*/
    public double getAmount() {
        return amount;
    }

    /*Chong chong tre ne Nobita.*/
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*Chong chong tre ne Nobita.*/
    public double getBalance() {
        return balance;
    }
}
