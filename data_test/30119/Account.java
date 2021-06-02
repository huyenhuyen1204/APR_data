import java.text.DecimalFormat;
import java.util.ArrayList;


public class Account {
    private double balance = 0;
    ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
    public void printTransaction(){
        DecimalFormat fm = new DecimalFormat("0.00");
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getOperation().equals("deposit")){
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + fm.format(arrayList.get(i).getAmount()) + ". So du luc nay: $" + fm.format(arrayList.get(i).getBalance()) + ".");
            }else {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + fm.format(arrayList.get(i).getAmount()) + ". So du luc nay: $" + fm.format(arrayList.get(i).getBalance()) + ".");
            }
        }
    }
    public ArrayList addTransaction(double amount, String operation){
        if(!operation.equals("withdraw") && !operation.equals("deposit"))
            System.out.println("Yeu cau khong hop le!");
        else if(operation.equals("withdraw")){
            withdraw(amount);
        } else deposit(amount);
        return arrayList;
    }

    private void deposit(double amount){
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else {
            this.balance = balance + amount;
            arrayList.add(new Transaction("deposit", amount, balance));
        }
    }
    private void withdraw(double amount){
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if(amount > this.balance) System.out.println("So tien ban rut vuot qua so du!");
        else {
            this.balance = balance - amount;
            arrayList.add(new Transaction("withdraw", amount, balance));
        }
    }
    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(-1,"deposit");
        acc.addTransaction(-1,"withdraw");
        acc.printTransaction();
    }



}
