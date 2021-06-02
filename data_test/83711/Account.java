import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * yay.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance = balance + amount;
            transactionList.add(new Transaction("deposit", amount, balance));
        }
    }

    /**
     * yay.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
            transactionList.add(new Transaction("withdraw", amount, balance));
        }
    }

    /**
     * yay.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    /**
     * yay.
     */
    public void printTransaction() {
        String s = "";
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                s = s + "Giao dich " + (i + 1) + ": " + "Nap tien $"
                        + String.format("%.2f", transactionList.get(i).getAmount())
                        + ". So du luc nay: $" + String.format("%.2f", transactionList.get(i).getBalance()) + "." + "\n";
            } else if (transactionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                s = s + "Giao dich " + (i + 1) + ": " + "Rut tien $"
                        + String.format("%.2f", transactionList.get(i).getAmount())
                        + ". So du luc nay: $" + String.format("%.2f", transactionList.get(i).getBalance()) + "." + "\n";
            }
        }
        System.out.println(s);
    }

    /**
     * yay.
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * yay.
     */
    public Account() {
        this.balance = 0;
    }
}
