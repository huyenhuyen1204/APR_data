
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private double deposit;
    private double withdraw;
    List<Transaction> transactionList;

    public Account() {
        this.balance = 0;
        this.transactionList = new ArrayList<Transaction>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            this.transactionList.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            deposit(amount);
            this.transactionList.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            String operation;
            Transaction transaction = transactionList.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                operation = " Nap tien $";
            } else {
                operation = " Rut tien $";
            }
            //Giao dich 1: Nap tien $2000.26. So du luc nay: $2000.26.
            double a = (double) Math.round(transaction.getAmount() * 100) / 100;
            double b = (double) Math.round(transaction.getBalance() * 100) / 100;
            System.out.println("Giao dich " + (i + 1) + ":" + operation + a + ". So du luc nay: $" + b + ".");
        }
    }

    public static void main(String[] args) {

    }
}
