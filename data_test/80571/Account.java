import java.util.ArrayList;

public class Account {
    private double balance = 0d;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions.add(new Transaction(Transaction.DEPOSIT,
                    amount, this.balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            if (amount > this.balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                this.balance -= amount;
                transactions.add(new Transaction(Transaction.WITHDRAW,
                        amount, this.balance));
            }
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            if (operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
            } else {
                System.out.println("Yeu cau khong hop le!");
            }
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transactions.get(i).getOperation().
                    equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            System.out.println((double) Math.round(
                    transactions.get(i).getAmount() * 100.00) / 100.0 +
                    ". So du luc nay: $" +
                    (double) Math.round(transactions.get(i).
                            getBalance() * 100.00) / 100.0 + ".");
        }
    }
}
