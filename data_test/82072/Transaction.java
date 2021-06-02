public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    
    static final String DEPOSIT = "deposit";
    static final String WITHDRAW = "withdraw";
    
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
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
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (operation.equals(Transaction.DEPOSIT)) {
            builder.append("Nap tien $").append(String.format("%.2f", amount));
            builder.append(". So du luc nay: ").append(String.format("%.2f", balance));
            builder.append(".");
            return builder.toString();
        }
        if (operation.equals(Transaction.WITHDRAW)) {
            builder.append("Rut tien $").append(String.format("%.2f", amount));
            builder.append(". So du luc nay: ").append(String.format("%.2f", balance));
            builder.append(".");
            return builder.toString();
        }
        return null;
    }
}
