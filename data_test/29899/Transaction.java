public class Transaction {
    private String oparation; // tên loại giao dịch
    private double amount; // số tiền giao dịch
    private double balance; // số dư còn lại
    public static final String DESPOSIT = "desposit", WITHDRAW = "withdraw";

    public Transaction(String oparation, double amount, double balance) {
        this.oparation = oparation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOparation() {
        return oparation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setOparation(String oparation) {
        this.oparation = oparation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
