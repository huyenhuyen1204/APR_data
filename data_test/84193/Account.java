import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.print("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.print("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.print("So tien ban rut vuot qua so du!");
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            if (amount < 0) {
                deposit(amount);
            } else {
                transactions.add(new Transaction(operation, amount, balance += amount));
            }
        } else {
            if (operation.equals(Transaction.WITHDRAW)) {
                if (amount < 0 || amount > balance) {
                    withdraw(amount);
                } else {
                    transactions.add(new Transaction(operation, amount, balance -= amount));
                }
            } else {
                System.out.print("Yeu cau khong hop le");
            }
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            String s;
            if (transactions.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                s = "Nap tien $";
            } else {
                s = "Rut tien $";
            }
            System.out.println("Giao dich " + i + 1 + ": " + s
                    + (double)Math.round(transactions.get(i).getAmount() * 100) / 100
                    + ". So du luc nay: $"
                    + (double)Math.round(transactions.get(i).getBalance() * 100) / 100);
        }
    }
}
