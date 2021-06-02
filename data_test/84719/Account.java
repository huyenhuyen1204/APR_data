import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     *bla.
     */
    public Account() {
    }

    /**
     *bla.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     *bla.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     *bla.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     *bla.
     */
    public void printTransaction() {
        int i = 1;
        for (Transaction t : transitionList) {
            System.out.print("Giao dich " + i + ": ");
            if (t.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
                System.out.printf("%.2f", t.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", t.getBalance());
                System.out.println(".");
            } else if (t.getOperation().equals(Transaction.WITHDRAW)) {
                System.out.print("Rut tien $");
                System.out.printf("%.2f", t.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", t.getBalance());
                System.out.println(".");
            }
            i++;
        }
    }

    /**
     *bla.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(1000, "deposit");
        acc.addTransaction(2000, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}


