import java.lang.*;
import java.util.ArrayList;

/**
 * .
 * @author Nguyen Quyet Thang .
 */
public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * .
     * @param amount .
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * .
     * @param amount .
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * .
     * @param amount .
     * @param operation .
     */
    public void addTransaction(double amount, String operation) {
        if (!(operation.equals(Transaction.DEPOSIT)
                || operation.equals(Transaction.WITHDRAW))) {
            System.out.println("Yeu cau khong hop le!");
        }
        if (operation.equals(Transaction.DEPOSIT)) {
            balance += amount;
            Transaction trans = new Transaction("deposit", amount, balance);
            transactionList.add(trans);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            balance -= amount;
            Transaction trans = new Transaction("withdraw", amount, balance);
            transactionList.add(trans);
        }
    }

    /**
     * .
     */
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich "
                        + (i + 1) + ": " +
                "Nap tien $" + String.format("%.2f", transactionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", transactionList.get(i).getBalance()) + ".");
            }
            if (transactionList.get(i).getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (i + 1) + ": "
                        + "Rut tien $" + String.format("%.2f", transactionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        +  String.format("%.2f", transactionList.get(i).getBalance()) + ".");
            }
        }
    }
}
