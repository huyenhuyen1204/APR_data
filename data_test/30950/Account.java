import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance = 0;
    ArrayList<Transaction> accountList = new ArrayList<Transaction>();

    private void deposit(double amount){
        if (amount > 0) this.balance += amount;
        else System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount){
        if (amount > 0){
            if (amount > this.balance)
                System.out.println("So tien ban rut vuot qua so du!");
            else
                this.balance -= amount;
        }
        else if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
    }

    public void addTransaction(double amount, String operation){
        if (operation == "deposit")
            deposit(amount);
        else if (operation == "withdraw")
            withdraw(amount);
        else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        accountList.add(new Transaction(operation, amount, this.balance));
    }

    public void printTransaction(){
        Transaction transaction;
        DecimalFormat df = new DecimalFormat("###.##");
        for (int i = 0; i < accountList.size(); i++){
            transaction = accountList.get(i);
            System.out.print("Giao dich " + (i+1) + ": ");
            if (transaction.getOperation() == "deposit") System.out.print("Nap tien $");
            else  System.out.print("Rut tien $");
            System.out.printf("%.2f. So du luc nay: $%.2f. \n",(double)((Math.round(transaction.getAmount() * 100))) / 100,(double)((Math.round(transaction.getBalance() * 100))) / 100);
        }
    }

}
