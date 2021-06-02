import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**
     * bla bla.
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transitionList.add(new Transaction("Nap tien ", amount, balance));
        }
    }

    /**
     * bla bla.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transitionList.add(new Transaction("Rut tien ", amount, balance));
        }
    }

    /**
     * bla bla.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * bla bla.
     */
    public void printTransaction() {
        int counter = 0;
        for (Transaction transaction : transitionList) {
            counter++;
            System.out.println("Giao dich " + counter + ": " + transaction.getOperation() + "$"
                    + String.format("%.2f", transaction.getAmount())
                    + ". So du luc nay: " + "$"
                    + String.format("%.2f", transaction.getBalance()) + ".");
        }
    }
}
