import java.util.concurrent.SynchronousQueue;
import java.util.ArrayList;

public class Account{
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if(amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount) {
        if(amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        if(amount > this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
    }

    public void addTransaction(double amount, String operation) {
        if(operation.equals("deposit") || operation.equals("withdraw")) {
            if(operation.equals("deposit")) {
                this.deposit(amount);
                amount = (double) Math.round(amount * 100)/100;
                this.balance = (double) Math.round((this.balance + amount) * 100)/100;
                transitionList.add(new Transaction("deposit", amount, this.balance));
            }
            else{
                this.withdraw(amount);
                amount = (double) Math.round(amount * 100)/100;
                this.balance = (double) Math.round((this.balance - amount) * 100)/100;
                transitionList.add(new Transaction("withdraw", amount, this.balance));
            }
        }
        else
            System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for(int i = 0; i < transitionList.size(); i++) {
            if(transitionList.get(i).getOperation().equals("deposit")) {
                if(transitionList.get(i).getAmount() > 0)
                    System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f\n", i+1, transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
                else
                    System.out.printf("Giao dich %d: So tien ban nap vao khong hop le!\n", i+1);
            }
            else if(transitionList.get(i).getOperation().equals("withdraw")) {
                if(transitionList.get(i).getAmount() > 0 && transitionList.get(i).getBalance() >= transitionList.get(i).getAmount())
                    System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f\n", i+1, transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
                else if(transitionList.get(i).getAmount() <= 0)
                    System.out.printf("Giao dich %d: So tien ban rut ra khong hop le!\n", i+1);
                else if(transitionList.get(i).getAmount() > 0 && transitionList.get(i).getBalance() < transitionList.get(i).getAmount())
                    System.out.printf("Giao dich %d: So tien ban rut vuot qua so du!\n", i+1);
            }
            else
                System.out.printf("Giao dich %d: Yeu cau khong hop le!\n", i+1);

        }
    }
}
