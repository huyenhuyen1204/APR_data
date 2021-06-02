import java.util.ArrayList;

public class Account {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    private double balance = 0;
    private ArrayList<String> transitionList = new ArrayList<String>();

    private void deposit( double amount ) {
        amount = (double) Math.round(amount*100)/100;
        if( amount < 0 ) {
            System.out.println( "So tien ban nap vao khong hop le!" );
        } else {
            this.balance += amount;
            String tmp = "Nap tien $" + amount + ". So du luc nay: $" + this.balance + ".";
            transitionList.add(tmp);
        }
    }

    private void withdraw(double amount) {
        amount = (double) Math.round(amount*100)/100;
        if(amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if( amount > this.balance ) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount; 
            String tmp = "Rut tien $" + amount + ". So du luc nay: $" +this.balance + ".";
            transitionList.add(tmp);
        }
    }

    public void addTransaction(double amount, String operation) {
        if( operation.equals(DEPOSIT) ) {
            deposit(amount);
        } else if( operation.equals(WITHDRAW) ) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for(int i = 0; i < transitionList.size(); i++) {
            int k = i+1;
            System.out.println( "Giao dich " + k + ": " + transitionList.get(i));
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();  
        acc.addTransaction(2000.255,"deposit");  
        acc.addTransaction(1000,"withdraw");
          
        acc.printTransaction();
    }
}