import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * cmt.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** cmt. */
    public double getBalance() {
        return balance;
    }

    /** cmt. */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** cmt. */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /** cmt. */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * cmt.
     */
    private void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * cmt.
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
     * cmt.
     */
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction trans = transactions.get(i);
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (trans.getOperation().equalsIgnoreCase(Transaction.DEPOSIT)) {
                System.out.print("Nap tien: $");
            } else {
                System.out.print("Rut tien: $");
            }
            System.out.print(Math.round(trans.getAmount() * 100) / 100.0 + ". ");
            System.out.print("So du luc nay: " + Math.round(trans.getBalance() * 100) / 100.0 + ".\n");
        }
    }
}
