public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     *phuong thuc khoi tao.
     */
    public Transaction() {
    }

    /**
     * phuong thuc khoi tao co tham so.
     * @param operation ten giao dich.
     * @param amount so tien giao dich.
     * @param balance so du.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    //Getter & setter
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    @Override
    public String toString() {
        if (operation.equals("withdraw")) {
            return "Rut tien $" +  String.format("%.2f", amount) + ". So du luc nay: $" + String.format("%.2f", balance) + ".";
        } else {
            return "Nap tien $" + String.format("%.2f", amount) + ". So du luc nay: $" + String.format("%.2f", balance) + ".";
        }
    }
}
