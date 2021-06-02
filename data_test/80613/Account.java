import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /** binhDang. */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** binhDang. */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("So tien ban rut ra vuot qua so du!");
            } else {
                balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /** binhDang. */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactions.add(new Transaction("deposit", amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactions.add(new Transaction("withdraw", amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** binhDang. */
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transactions.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien $");
            } else {
                System.out.print("Nap tien $");
            }
            System.out.print((double) Math.round(transactions.get(i).getAmount() * 100) / 100);
            System.out.print(". So du luc nay: $");
            System.out.print((double) Math.round(transactions.get(i).getBalance() * 100) / 100);
            System.out.println(".");
        }
    }
}
