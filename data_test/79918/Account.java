import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * hgasdg.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactionList.add(new Transaction(operation, amount, balance));
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
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * hgasdg.
     */
    public void printTransaction() {
        int i = 1;
        for (Transaction transaction : transactionList) {
            String s = "Giao dich " + i++ + ": ";
            String a = String.format("%.2f", transaction.getAmount());
            String b = String.format("%.2f", transaction.getBalance());
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                s += "Nap tien $" + a + ". ";
                s += "So du luc nay: $" + b + ".";
            } else {
                s += "Rut tien $" + a + ". ";
                s += "So du luc nay: $" + b + ".";
            }
            System.out.println(s);
        }
    }
}
