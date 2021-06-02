import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private void deposit(double amount){
        if (amount < 0 ){
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;
    }
    private void withdraw(double amount){
        if (amount < 0 ){
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > this.balance ){
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
    }
    public void addTransaction(double amount , String operation){
        if (operation == "DEPOSIT" || operation == "deposit"){
            this.deposit(amount);
            Transaction a = new Transaction("deposit", amount, balance);
            transitionList.add(a);
            return;
        }
        if (operation == "WITHDRAW" || operation == "withdraw"){
            this.withdraw(amount);
            Transaction b = new Transaction("withdraw", amount, balance);
            transitionList.add(b);
            return;
        }
        System.out.println("Yeu cau khong hop le!");
        return;
    }
    public void printTransaction(){
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i =0;i<transitionList.size();i++){
            System.out.print("Giao dich " + (i+1) + ":");
            if (transitionList.get(i).getOperation() == "deposit"){
            System.out.print(" Nap tien $" + df.format((double) Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0) + ". So du luc nay: $"
                    + df.format((double) Math.round(transitionList.get(i).getBalance() * 100) / 100) + "\n");
            }
            if (transitionList.get(i).getOperation() == "withdraw"){
                System.out.print(" Rut tien $" + df.format((double) Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0) + ". So du luc nay: $"
                        + df.format((double) Math.round(transitionList.get(i).getBalance() * 100) / 100 )+ "\n");
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
