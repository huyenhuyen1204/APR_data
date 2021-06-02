
public class Transaction{

    private String operation;
    private double amount;
    private double balance; //so du
    private final static String DEPOSIT = "deposit";
    private final static String WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance){
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public void setOperation(String operation){
        this.operation = operation;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getOperation(){ return operation; }
    public double getAmount(){ return amount; }
    public double getBalance(){ return balance; }

}