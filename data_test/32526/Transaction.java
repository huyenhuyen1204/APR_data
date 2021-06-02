public class Transaction {
    private String opration; double amount, balance;
    public static final  String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    Transaction(String opration, double amount, double balance)
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

    public String getOpration() {
        return opration;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOpration(String opration) {
        this.opration = opration;
    }
}

