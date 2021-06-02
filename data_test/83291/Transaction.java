public class Transaction {
    private String operation;
    private double amount;
    private double blance;

    public static final String despoit = "DESPOSIT";
    public static final String withdraw = "WITHDRAW";

    public Transaction() {
    }

    public Transaction(String operation, double amount, double blance) {
        this.operation = operation;
        this.amount = amount;
        this.blance = blance;
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

    public double getBlance() {
        return blance;
    }

    public void setBlance(double blance) {
        this.blance = blance;
    }
}
