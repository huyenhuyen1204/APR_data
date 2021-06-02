import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList  = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance = this.balance - amount;
        }

    }

    /**
     * hello.
     * @param amount 1.
     * @param operation 2.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));

        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * in du lieu.
     */
    public void printTransaction() {
        int count = 0;
        for (Transaction transaction : transitionList) {
            count++;
            if (transaction.getOperation().equals(transaction.WITHDRAW)) {
                System.out.print("Giao dich " + count + ": Rut tien $");
                System.out.printf("%.2f", transaction.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transaction.getBalance());
                System.out.print(".");
                System.out.println();
            } else if (transaction.getOperation().equals(transaction.DEPOSIT)) {
                System.out.print("Giao dich " + count + ": Nap tien $");
                System.out.printf("%.2f", transaction.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transaction.getBalance());
                System.out.print(".");
                System.out.println();
            }
        }
    }
}
