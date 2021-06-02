public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        if (operation.equals(DEPOSIT)) {
            return "Nap tien "
                    + "$" + String.format("%.2f", amount)
                    + ". So du luc nay: "
                    + "$" + String.format("%.2f", balance) + ".";
        } else if (operation.equals(WITHDRAW)) {
            return "Rut tien "
                    + "$" + String.format("%.2f", amount)
                    + ". So du luc nay: "
                    + "$" + String.format("%.2f", balance) + ".";
        }
        return null;
    }
}
