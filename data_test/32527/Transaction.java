public class Transaction {
    private String opration;
    private double amount;
    private double balance;
    public static final  String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public Transaction(String opration, double amount, double balance)
    {
        this.opration = opration;
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOpration() {
        return opration;
    }

    public void setOpration(String opration) {
        this.opration = opration;
    }
}

