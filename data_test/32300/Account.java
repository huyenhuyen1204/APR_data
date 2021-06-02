import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList= new ArrayList<Transaction>();

    private void deposit(double amount){
        if(amount<=0) System.out.println("So tien ban nap vao khong hop le!");
        transitionList.add(new Transaction( "Nap tien " , amount,balance+amount));
        balance+=amount;
    }

    private void withdraw(double amount){
        if(amount<=0) System.out.println("So tien ban rut ra khong hop le!");
        if(amount>balance) System.out.println("So tien ban rut vuot qua so du!");
        transitionList.add(new Transaction("Rut tien ",amount,balance-amount));
        balance-=amount;
    }

    public void addTransaction(double amount,String operation){
        if(operation!=Transaction.DEPOSIT&&operation!=Transaction.WITHDRAW)
            System.out.println("Yeu cau khong hop le!");

        if(operation==Transaction.DEPOSIT){
            deposit(amount);
        }
        if(operation==Transaction.WITHDRAW){
            withdraw(amount);
        }
    }
    public void printTransaction(){

        for(int i=0; i<transitionList.size(); i++)
            {
                String amountS= String.format("%.2f",transitionList.get(i).getAmount());
                String balanceS= String.format("%.2f",transitionList.get(i).getBalance());
                System.out.print("Giao dich "+(i+1)+": "+transitionList.get(i).getOperation());
                System.out.println("$"+amountS+". So du luc nay: $"+balanceS+".");
            }
    }
    public static void main(String args[]){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
