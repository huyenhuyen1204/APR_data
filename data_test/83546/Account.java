import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList = new ArrayList<Transaction>();

    /**hu hu.*/
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transactionList.add(new Transaction("deposit", amount, balance));
        }
    }

    /**hu hu.*/
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transactionList.add(new Transaction("withdraw", amount, balance));
        }
    }

    /**hu hu.*/
    public void addTransaction(double amount, String operaion) {
        if (operaion.equals("deposit")) {
            deposit(amount);
        } else if (operaion.equals("withdraw")) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**hu hu.*/
    public void printTransaction() {
        int d = 1;
        for (Transaction tran : transactionList) {
            System.out.print("Giao dich " + d + ": ");
            if (tran.getOperation().equals("deposit")) {
                System.out.print("Nap tien ");
            } else {
                System.out.print("Rut tien ");
            }
            System.out.print("$" + (double) Math.round(tran.getAmount() * 100) / 100);
            System.out.print(". So du luc nay: ");
            System.out.println("$" + (double) Math.round(tran.getBalance() * 100) / 100 + ".");
            ++d;
        }
    }
}
