import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Nap tien.
     * param amount
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            setBalance(getBalance() + amount);
        }
    }

    /**
     * Rut tien.
     * param amount
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    /**
     * Them giao dich.
     * param amount
     * param operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT) && amount > 0) {
            deposit(amount);
            Transaction tran = new Transaction("Nap tien",
                    (double) Math.round(amount * 100) / 100,
                    (double) Math.round(getBalance() * 100) / 100);
            transactions.add(tran);
        } else if (operation.equals(Transaction.WITHDRAW)
                && amount > 0 && amount < getBalance()) {
            withdraw(amount);
            Transaction tran1 = new Transaction("Rut tien",
                    (double) Math.round(amount * 100) / 100,
                    (double) Math.round(getBalance() * 100) / 100);
            transactions.add(tran1);
        } else if (operation.equals(Transaction.DEPOSIT) == false
                || operation.equals(Transaction.WITHDRAW) == false) {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * In ra cac giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Giao dich " + (i+1) + ": "
                    + transactions.get(i).getOperation()
                    + " $" + transactions.get(i).getAmount() + ". " + "So du luc nay: "
                    + transactions.get(i).getBalance() + ".");
        }
    }
}
