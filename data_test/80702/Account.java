import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> myTransaction;

    /** Mai Huy. */
    public Account() {
        this.balance = 0;
        myTransaction = new ArrayList<Transaction>();
    }

    /** Mai Huy. */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** Mai Huy. */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /** Mai Huy. */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            myTransaction.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            myTransaction.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** Mai Huy. */
    public void printTransaction() {
        int size = myTransaction.size();
        for (int i = 0; i < size; i++) {
            if (myTransaction.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Giao dich " + (i + 1) + ": Nap tien $");
                double roundAmount = (double) Math.round(myTransaction.get(i).getAmount() * 100) / 100;
                double roundBalance = (double) Math.round(myTransaction.get(i).getBalance() * 100) / 100;
                System.out.printf("%.2f", roundAmount);
                System.out.print(". So du luc nay:  $");
                System.out.printf("%.2f", roundBalance);
                System.out.println(".");
            } else {
                System.out.print("Giao dich " + (i + 1) + ": Rut tien $");
                double roundAmount = (double) Math.round(myTransaction.get(i).getAmount() * 100) / 100;
                double roundBalance = (double) Math.round(myTransaction.get(i).getBalance() * 100) / 100;
                System.out.printf("%.2f", roundAmount);
                System.out.print(". So du luc nay:  $");
                System.out.printf("%.2f", roundBalance);
                System.out.println(".");
            }
        }
    }
}
