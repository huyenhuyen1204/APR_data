import java.math.BigDecimal;

public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit" ;
    public static final String WITHDRAW= "withdraw";

    public Transaction(String operation, double amount, double balance){

        /*BigDecimal a = new BigDecimal("1000");
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println(roundOff);

        amount=(float) Math.round(amount*100)/100;*/

        this.operation=operation;
        this.amount=amount;
        this.balance=balance;

        //System.out.println(amount+" "+balance);

    }
    public String getOperation(){
        return operation;
    }
    public void setOperation(String operation){
        this.operation=operation;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount=amount;
        amount= Math.round(amount*100)/100;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
        balance= Math.round(balance*100)/100;
    }
    
}
