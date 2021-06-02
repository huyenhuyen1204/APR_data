import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;


    /**
     * Constructor.
     */
    public Account(double balance, ArrayList<Transaction> history) {
        this.balance = balance;
        this.transitionList = history;
    }

    public Account() {
        balance = 0;
        transitionList = new ArrayList<Transaction>();
    }

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println(" So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction transaction = new Transaction("DEPOSIT", amount, balance);
            transitionList.add(transaction);
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction("WITHDRAW", amount, balance);
            transitionList.add(transaction);
        }
    }

    /**
     * add new transaction.
     * @param amount    so tien
     * @param operation ten hanh dong
     */
    public void addTransaction(double amount, String operation) {
        if (operation.compareToIgnoreCase("Deposit") != 0
                && operation.compareToIgnoreCase("Withdraw") != 0) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.compareToIgnoreCase("Deposit") == 0) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
        }
    }

    /**
     * print trasactions.
     */
    public void printTransaction() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().compareToIgnoreCase("Deposit") == 0) {
                System.out.println("Giao dich " + (i + 1) + ": " + "Nap tien $"
                        + formatter.format(transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + formatter.format(transitionList.get(i).getBalance()) + ".");
            } else {
                System.out.println("Giao dich " + (i + 1) + ": " + "Rut tien $"
                        + formatter.format(transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + formatter.format(transitionList.get(i).getBalance()) + ".");
            }
        }
    }
}
