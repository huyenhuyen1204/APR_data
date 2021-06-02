import java.util.ArrayList;

public class Account {
    private double balanace;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        if (amount > balanace) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    public void addTransaction(double amount, String operation) {
        Transaction trans;
        amount = (double) Math.round(amount * 100) / 100;
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            balanace += amount;
            trans = new Transaction(operation, amount, balanace);
            transactions.add(trans);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            balanace -= amount;
            trans = new Transaction(operation, amount, balanace);
            transactions.add(trans);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getOperation().equals("deposit")) {
                System.out.println("Giai dich " + (i + 1) + ": Nap tien $" + transactions.get(i).getAmount() + ". So du luc nay: $" + transactions.get(i).getBalance() + ".");
            } else {
                System.out.println("Giai dich " + (i + 1) + ": Rut tien $" + transactions.get(i).getAmount() + ". So du luc nay: $" + transactions.get(i).getBalance() + ".");
            }
        }
    }
}
