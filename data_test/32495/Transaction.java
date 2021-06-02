public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public final static String DEPOSIT = "DEPOSIT";
    public final static String WITHDRAW = "WITHDRAW";

    public Transaction(String operation, double amount, double balance){
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperetion() {
        return operation;
    }

    public void setOperetion(String operetion) {
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
