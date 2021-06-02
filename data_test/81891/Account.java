import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.setBalance(this.getBalance() + amount);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.getBalance()) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    /**
     * ham.
     * @param amount ham.
     * @param operation ham.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            this.setBalance(this.getBalance() + amount);
        } else if (operation.equals("withdraw")) {
            this.setBalance(this.getBalance() - amount);
        }

             Transaction tra = new Transaction(operation, amount, balance);
             transitionList.add(tra);
    }

    /**
     * ham.
     */
    public void printTransaction() {
        int i = 1;


         for (Transaction t : transitionList) {
             //System.out.printf( "%2.2f", t.getAmount());
             double a = (double) Math.round(t.getAmount() * 100) / 100;
             double a1 = (double) Math.round(t.getBalance() * 100) / 100;
             if (t.getOperation().equals(t.DEPOSIT)) {
                 System.out.print("Giao dich " + i + ": " + "Nap tien $");
                 System.out.printf( "%2.2f", t.getAmount());
                 System.out.print(". So du luc nay: $");
                 System.out.printf( "%2.2f", t.getBalance());
                 System.out.println(".");
             } else if (t.getOperation().equals(t.WITHDRAW)) {
                 System.out.print("Giao dich " + i + ": " + "Nap tien $");
                 System.out.printf( "%2.2f", t.getAmount());
                 System.out.print(". So du luc nay: $");
                 System.out.printf( "%2.2f", t.getBalance());
                 System.out.println(".");
             } else {
                 System.out.println("Yeu cau khong hop le!");
             }
             i++;
         }

    }

    /**
     * ham.
     * @param args ham.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.1, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();

    }
}
