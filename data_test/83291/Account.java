import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private double blance;

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();


    public Account() {
    }

    private void deposit(double amount) {
        Transaction transaction = new Transaction();
        double x;
        if (transactions.size() == 0) {
            x = 0;
        } else {
            x = transactions.get(transactions.size() - 1).getAmount();
        }
        transaction.setAmount(amount);
        transaction.setBlance(x + amount);
        transaction.setOperation("Nap tien");
        transactions.add(transaction);
    }

    private void withdraw(double amount) {
        Transaction transaction = new Transaction();
        double x;
        if (transactions.size() == 0) {
            x = 0;
        } else {
            x = transactions.get(transactions.size() - 1).getAmount();
        }
        transaction.setAmount(amount);
        transaction.setBlance(x - amount);
        transaction.setOperation("Rut tien");
        transactions.add(transaction);
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            double x = (double) Math.round(transactions.get(i).getAmount() * 100) / 100;
            double y = (double) Math.round(transactions.get(i).getBlance() * 100) / 100;
            NumberFormat formatter = new DecimalFormat("0.00");
            String s1 = formatter.format(x);
            String s2 = formatter.format(y);
            System.out.println("Giao dich " + (i + 1) + ": " + transactions.get(i).getOperation()
                    + " $" + s1 + ". So du luc nay: $" + s2 + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();

    }
}
