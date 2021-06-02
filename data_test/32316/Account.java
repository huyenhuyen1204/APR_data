
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount){
        if (amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
            return;
        }
        else{
            balance += amount;
        }
    }
    private void withdraw(double amount){
        if (amount <= 0) {
            System.out.print("So tien ban rut ra khong hop le!");
            return;
        }
        else if (amount > balance) {
            System.out.print("So tien ban rut vuot qua so du!");
            return;
        }
        else{
            balance -=amount;
        }
    }
    public void addTransaction(double amount, String operation){
        if (!operation.equals( "withdraw") && !operation.equals("deposit")){
            System.out.print("Yeu cau khong hop le!");
            return;
        }
        else {
            if (operation.equals("deposit")) {
                    deposit(amount);
                    Transaction tt = new Transaction(operation, amount, balance);
                    transitionList.add(tt);
            }
            else if (operation.equals("withdraw")){
                withdraw(amount);
                Transaction tt = new Transaction(operation,amount,balance);
                transitionList.add(tt);
            }
        }
    }
    public void printTransaction(){
        for (int i = 0; i < transitionList.size(); i++){
            int j = i + 1;
            System.out.print("Giao dich "+j+": ");

            if (transitionList.get(i).getOperation() == "withdraw")
                System.out.printf("Rut tien $%.2f. So du luc nay: $%.2f.", transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            else if (transitionList.get(i).getOperation() == "deposit")
                System.out.printf("Nap tien $%.2f. So du luc nay: $%.2f.", transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Account ac = new Account();
        //ac.balance = 0;
        ac.addTransaction(2000.255, "deposit");
        ac.addTransaction(1000.00, "withdraw");
        ac.printTransaction();
        System.out.println();
    }
}
