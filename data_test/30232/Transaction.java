public class Transaction {
    private String operation; // tên loại giao dịch
    private double amount; // số tiền giao dịch
    private double balance; // số tiền du còn lại trong tài khoản
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperation() {
        return this.operation;
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
