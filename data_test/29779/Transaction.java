public class Transaction {
    private String operation; // Loai giao dich
    private double amount;  // So tien giao dich
    private double balance; // So du trong tai khoan

    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAW = "WITHDRAW";

    // Constructor
    public Transaction() {
        this.operation = "";
        this.amount = 0;
        this.balance = 0;
    }

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    // Getter
    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    // Setter
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
