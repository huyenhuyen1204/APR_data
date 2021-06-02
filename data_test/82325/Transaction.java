public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT;
    public static final String WITHDRAW;
    static {
        DEPOSIT = "gui";
        WITHDRAW = "rut";
    }

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

    public static String getDEPOSIT() {
        return DEPOSIT;
    }

    public static String getWITHDRAW() {
        return WITHDRAW;
    }

    @Override
    public String toString() {
        if (operation.equals("deposit")) {
            return "Nap tien $" + ((double) Math.round(amount * 100) / 100) + ". So du luc nay: $"
                    + ((double) Math.round(balance * 100) / 100) + ".";
        } else {
            return "Rut tien $" + ((double) Math.round(amount * 100) / 100) + ". So du luc nay: $"
                    + ((double) Math.round(balance * 100) / 100) + ".";
        }
    }
}
