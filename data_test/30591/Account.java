import java.util.ArrayList;

public class Account {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit( double amount ) {
        amount = (double) Math.round(amount*100)/100;
        if( amount < 0 ) {
            System.out.println( "So tien ban nap vao khong hop le!" );
        } else {
            this.balance += amount;
            transitionList.add(new Transaction("deposit", amount, this.balance));
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
            transitionList.add(new Transaction("withdraw", amount, this.balance));
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
            if(transitionList.get(i).getOperation().equals(DEPOSIT) ==  true) {
                String s_amount = String.format("%.2f", transitionList.get(i).getAmount());
                String s_balance = String.format("%.2f", transitionList.get(i).getBalance());
                System.out.println( "Giao dich " + k + ": Nap tien $" + s_amount + ". So du luc nay: $" + s_balance);
            } else {
                String s_amount = String.format("%.2f", transitionList.get(i).getAmount());
                String s_balance = String.format("%.2f", transitionList.get(i).getBalance());
                System.out.println( "Giao dich " + k + ": Rut tien $" + s_amount + ". So du luc nay: $" + s_balance);
            }
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();  
        acc.addTransaction(2000.255,"deposit");  
        acc.addTransaction(1000,"withdraw");

        acc.printTransaction();
    }
}