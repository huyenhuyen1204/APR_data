import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transitionList;

    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }

    /**
     * Javadoc.
     */
    public void printTransaction() {
        int n = transitionList.size();
        for (int i = 0; i < n; i++) {
            String s = "";
            double a = Math.round(transitionList.get(i).getAmount() * 100) / 100;
            double b = Math.round(transitionList.get(i).getBalance() * 100) / 100;
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                s = "Nap tien";
            } else {
                s = "Rut tien";
            }
            System.out.println("Giao dich " + i + ": " + s + " " + a + ". So du luc nay: " + b + ".");
        }
    }

    /**
     * javadoc.
     *
     * @param amount int.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        Transaction a = new Transaction(Transaction.DEPOSIT, amount, balance + amount);
        transitionList.add(a);
        this.setBalance(balance+amount);
    }

    /**
     * javadoc.
     *
     * @param amount int.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        Transaction a = new Transaction(Transaction.DEPOSIT, amount, balance - amount);
        transitionList.add(a);
        this.setBalance(balance-amount);
    }

    /**
     * javadoc.
     *
     * @param amount    int.
     * @param operation int.
     */
    void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transitionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transitionList = transactionList;
    }
}
