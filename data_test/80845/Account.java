import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> list = new ArrayList<Transaction>();

    /**
     * deposit.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            list.add(transaction);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * withdraw.
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount < balance) {
                balance -= amount;
                Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
                list.add(transaction);
            } else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * add.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * print.
     */
    public void printTransaction() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            Transaction transaction = list.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
                System.out.printf("%.2f",
                        (double) Math.round(transaction.getAmount() * 100) / 100);
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f",
                        (double) Math.round(transaction.getBalance() * 100) / 100);
                System.out.println(".");
            }
            if (transaction.getOperation().equals(Transaction.WITHDRAW)) {
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
