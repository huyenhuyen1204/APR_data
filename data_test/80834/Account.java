import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**
     * Something.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Something.
     */
    private void withdraw(double amount) {
        if (amount < balance) {
            if (amount > 0) {
                balance -= amount;
                Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
                transitionList.add(transaction);
            } else {
                System.out.println("So tien ban rut ra khong hop le!");
            }
        } else {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * Something.
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
     * Something.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            Transaction transaction = transitionList.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
                System.out.printf("%.2f", 
                        (double) Math.round(transaction.getAmount() * 100) / 100);
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f",
                        (double) Math.round(transaction.getBalance() * 100) / 100);
                System.out.println(".");
            } else {
                System.out.print("Rut tien $");
                System.out.printf("%.2f",
                        (double) Math.round(transaction.getAmount() * 100) / 100);
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f",
                        (double) Math.round(transaction.getBalance() * 100) / 100);
                System.out.println(".");
            }
        }
    }
}
