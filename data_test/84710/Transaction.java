public class Transaction {
    //khai bao
    private String operation; //ten loai giao dich
    private double amount; //so tien giao dich
    private double balance; //so du
    public static final String DEPOSIT = "deposit"; //gui tien
    public static final String WITHDRAW = "withdraw"; //rut tien


    /**
     * Phuong thuc khoi tao.
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    //getter,setter
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

}
