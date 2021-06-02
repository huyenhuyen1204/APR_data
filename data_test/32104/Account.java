
import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposite(double amount){
        if (amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else{
            balance += amount;
        }
    }
    private void withdraw(double amount){
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else{
            balance -=amount;
        }
    }
    public void addTransaction(double amount, String operation){
        if (operation != "withdraw" && operation != "deposite"){
            System.out.println("Yeu cau khong hop le!");
        }
        else {
            if (operation == "deposite") {
                if (amount <= 0){
                    deposite(amount);
                }
                else {
                    Transaction tt = new Transaction(operation, amount, this.balance);
                    transitionList.add(tt);
                }
            }
            else {
                if (amount <= 0 || amount > balance){
                    deposite(amount);
                }
                else {
                    Transaction tt = new Transaction(operation, amount, this.balance);
                    transitionList.add(tt);
                }
            }
        }
    }
    public void printTransaction(){
        for (int i = 0; i < transitionList.size(); i++){
            int j = i + 1;
            System.out.print("Giao dich "+j+": ");
            double n = Math.round((transitionList.get(i).getAmount()*100))/100;
            double m = Math.round(transitionList.get(i).getBalance()*100)/100;
            if (transitionList.get(i).getOperation() == "withdraw")
                System.out.print("Rut tien $"+n+". So du luc nay: $"+m+".");
            else if (transitionList.get(i).getOperation() == "deposite")
                System.out.print("Nap tien $"+n+". So du luc nay: $"+m+".");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Account ac = new Account();
        ac.balance = 88;
        ac.addTransaction(2.3, "withdraw");
        ac.printTransaction();
        System.out.println();
    }
}
