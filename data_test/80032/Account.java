import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> listTransactions = new ArrayList<>();


    /**
     * javadoc.
     */
    public Account() {
        balance = 0;
    }


    /**
     * javadoc.
     */
    public Account(double balance) {
        this.balance = balance;
    }


    /**
     * javadoc.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }


    /**
     * javadoc.
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }


    /**
     * javadoc.
     */
    public void addTransaction(double amount, String operation) {
        Transaction transaction = null;
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            listTransactions.add(transaction);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            listTransactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }


    /**
     * javadoc.
     */
    public void printTransaction() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (int i = 0; i < listTransactions.size(); ++i) {
            Transaction transaction = listTransactions.get(i);
            String result = "Giao dich " + (i + 1) + ": ";
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                result += "Nap tien";
            } else {
                result += "Rut tien";
            }
            result += " $" + formatter.format(transaction.getAmount()) + ". So du luc nay: $"
                    + formatter.format(transaction.getBalance()) + ".";
            System.out.println(result);
        }
    }
}
