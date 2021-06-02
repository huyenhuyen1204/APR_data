import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        } else {
            System.out.printf("So tien ban nap vao khong hop le!\n");
        }
    }

    private void withdraw(double amount){
        if (amount >= 0 && amount <= this.balance){
            this.balance -= amount;
        } else if(amount > this.balance){
            System.out.printf("So tien ban rut vuot qua so du!\n");
        } else {
            System.out.printf("So tien ban rut ra khong hop le!\n");
        }
    }

    public void addTransaction(double amount, String operation){
        if ( operation.equals("deposit") || operation.equals("withdraw") ) {
            if (operation.equals("deposit")) {
                this.deposit(amount);
                transitionList.add(new Transaction("deposit", amount, this.balance));
            } else {
                this.withdraw(amount);
                transitionList.add(new Transaction("withdraw", amount, this.balance));
            }
        } else System.out.printf("Yeu cau khong hop le!\n");
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals("deposit")) {
                if (transitionList.get(i).getAmount() > 0) {
                    System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", i + 1, transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
                } else System.out.printf("Giao dich %d: So tien ban nap khong hop le!\n", i + 1);
            } else if (transitionList.get(i).getOperation().equals("withdraw")) {
                if (transitionList.get(i).getAmount() > 0 && transitionList.get(i).getAmount() <= transitionList.get(i).getBalance()) {
                    System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", i + 1, transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
                } else if (transitionList.get(i).getAmount() > transitionList.get(i).getBalance()) {
                    System.out.printf("Giao dich %d: So tien ban rut vuot qua so du!\n", i + 1);
                } else
                    System.out.printf("Giao dich %d: So tien ban rut ra khong hop le!\n", i + 1);
            } else
                System.out.printf("Giao dich %d: Yeu cau khong hop le!\n", i + 1);
        }
    }

    public static void main(String[] args){
        Account acc= new Account();

        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(0,"deposit");
        acc.addTransaction(9999,"withdra");

        acc.printTransaction();
    }
}
