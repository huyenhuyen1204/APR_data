import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {

    private double balance;
    private ArrayList<Transaction> list = new ArrayList<>();

    private void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        } else {
        }
    }

    private void withdraw(double amount){
        if (amount >= 0 && amount <= this.balance){
            this.balance -= amount;
        } else if(amount > this.balance){
        } else {
        }
    }

    public void addTransaction(double amount, String operation){
        if ( operation.equals("deposit") || operation.equals("withdraw") ) {
            if (operation.equals("deposit")) {
                this.deposit(amount);
                list.add(new Transaction(operation, amount, this.balance));
            } else {
                this.withdraw(amount);
                list.add(new Transaction(operation, amount, this.balance));
            }
        } else list.add(new Transaction(operation, amount, this.balance));
    }

    public void printTransaction(){
        for (int i=0; i < list.size(); i++){
            if (list.get(i).getOperation().equals("deposit")) {
                if (list.get(i).getAmount() > 0) {
                    System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", i + 1, list.get(i).getAmount(), list.get(i).getBalance());
                } else
                    System.out.printf("Giao dich %d: So tien ban nap khong hop le!\n", i+1);
            } else if(list.get(i).getOperation().equals("withdraw")){
                if (list.get(i).getAmount() > 0 && list.get(i).getAmount() <= list.get(i).getBalance()){
                    System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", i + 1, list.get(i).getAmount(), list.get(i).getBalance());
                } else if (list.get(i).getAmount() > list.get(i).getBalance()) {
                    System.out.printf("Giao dich %d: So tien ban rut vuot qua so du!\n", i+1);
                } else
                    System.out.printf("Giao dich %d: So tien ban rut khong hop le!\n", i+1);
            } else
                System.out.printf("Giao dich %d: Yeu cau khong hop le!\n", i+1);
        }
    }

    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(0,"deposit");
        acc.addTransaction(9999,"withdraw");

        acc.printTransaction();
    }
}
