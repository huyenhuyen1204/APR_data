public class Transaction {
    private String operation; // tên loại giao dịch
    private double amount; // số tiền giao dịch
    private double balance; // số dư còn lại
    public static final String DEPOSIT = "deposit", WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
