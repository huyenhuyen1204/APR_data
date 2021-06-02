import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * hgasdg.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactions.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactions.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * hgasdg.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }

    }

    /**
     * hgasdg.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else if (amount > 0) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * hgasdg.
     */
    public void printTransaction() {
        int i = 0;
        for (Transaction transaction : transactions) {
            String s = "Giao dich " + i++ + ": ";
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                s += "Nap tien $" + transaction.getAmount() + ". ";
                s += "So du luc nay: $" + transaction.getBalance() + ".";
            } else {
                s += "Rut tien $" + transaction.getAmount() + ". ";
                s += "So du luc nay: $" + transaction.getBalance() + ".";
            }
            System.out.println(s);
        }
    }
}
