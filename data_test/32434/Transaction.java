public class Transaction{
    private String operation; // ten giao dich
    private double amount; // so tien giao dich
    private double balance;// so tien con lai trong tai khoan
    public static final String DEPOSIT = "deposit" ;
    public static final String WITHDRAW = "withdraw";
    public Transaction(String operation, double amount, double balance){
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

    public double getBalance() {
        return balance;
    }

    public static String getDEPOSIT() {
        return DEPOSIT;
    }

    public String getWITHDRAW() {
        return WITHDRAW;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}