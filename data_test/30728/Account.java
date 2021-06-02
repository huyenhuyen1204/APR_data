import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance ;

    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    public void addTransaction(double amount , String operation){
        if (operation.equals("withdraw"))withdraw(amount);
        else if (operation.equals("deposit"))deposit(amount);
        else System.out.println("Yeu cau khong hop le!");
    }

    private void deposit(double amount){
        if (amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else {
            balance = balance + amount;
            Transaction temp = new Transaction("deposit" , amount , balance );
            transitionList.add(temp);
        }
    }

    private void withdraw(double amount){
        if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if(amount > balance)System.out.println("So tien ban rut vuot qua so du!");
        else {
            balance = balance - amount;
            Transaction temp = new Transaction("withdraw" , amount , balance );
            transitionList.add(temp);
        }
    }

    public void printTransaction(){
        for (int i = 0 ; i < transitionList.size() ; i++){
            double a = transitionList.get(i).getAmount();
            double b = transitionList.get(i).getBalance();
            DecimalFormat f = new DecimalFormat("##.00");
            if (transitionList.get(i).getOperation().equals("deposit")){
                System.out.println("Giao dich " + (i+1) + ": Nap tien $" + f.format(a) + ". So du luc nay: $" + f.format(b) + ".");
            }
            if (transitionList.get(i).getOperation().equals("withdraw")){
                System.out.println("Giao dich " + (i+1) + ": Rut tien $" + f.format(a) + ". So du luc nay: $" + f.format(b) + ".");
            }
        }
    }

    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
