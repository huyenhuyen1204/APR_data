
import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private void deposite(double amount){
        if (amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount){
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        if (amount > balance)
            System.out.println("So tien ban rut vuot qua so du!");
    }
    public void addTransaction(double amount, String operation){
        if (operation != "WITHDRAW" && operation != "DEPOSITE"){
            System.out.println("Yeu cau khong hop le!");
        }
        else {
            Transaction tt = new Transaction(operation, amount, this.balance);
            transactions.add(tt);
        }
    }
    public void printTransaction(){
        for (int i = 0; i < transactions.size(); i++){
            int j = i + 1;
            System.out.print("Giao dich "+j+": ");
            double n = Math.round((transactions.get(i).getAmount()*100))/100;
            double m = Math.round(transactions.get(i).getBalance()*100)/100;
            if (transactions.get(i).getOperation() == "WITHDRAW")
                System.out.print("Rut tien $"+n+". So du luc nay: $"+m+".");
            else if (transactions.get(i).getOperation() == "DEPOSITE")
                System.out.print("Nap tien $"+n+". So du luc nay: $"+m+".");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Account ac = new Account();
        ac.balance = 88;
        ac.addTransaction(2.3, "WITHDRAW");
        ac.printTransaction();
    }
}
