import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();


    public Account() {
    }

    private void deposit(double amount) {
        if (amount > 0) {
            Transaction transaction = new Transaction();
            double x;
            if (transitionList.size() == 0) {
                x = 0;
            } else {
                x = transitionList.get(transitionList.size() - 1).getAmount();
            }
            transaction.setAmount(amount);
            transaction.setBalance(x + amount);
            transaction.setOperation("Nap tien");
            transitionList.add(transaction);
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            if (transitionList.size() == 0
                    || amount > transitionList.get(transitionList.size() - 1).getBalance()) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                Transaction transaction = new Transaction();
                double x;
                if (transitionList.size() == 0) {
                    x = 0;
                } else {
                    x = transitionList.get(transitionList.size() - 1).getAmount();
                }
                transaction.setAmount(amount);
                transaction.setBalance(x - amount);
                transaction.setOperation("Rut tien");
                transitionList.add(transaction);
                balance -= amount;
            }
        }
    }

    /**
     * them cac dao dich vào trasactionlist.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        } else {
            if (operation.equals("withdraw")) {
                withdraw(amount);
            } else {
                System.out.println("Yeu cau khong hop le!");
            }
        }
    }

    /**
     * in cac giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double x = (double) Math.round(transitionList.get(i).getAmount() * 100) / 100;
            double y = (double) Math.round(transitionList.get(i).getBalance() * 100) / 100;
            NumberFormat formatter = new DecimalFormat("0.00");
            String s1 = formatter.format(x);
            String s2 = formatter.format(y);
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i).getOperation()
                    + " $" + s1 + ". So du luc nay: $" + s2 + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(0,"withdraw");
        acc.printTransaction();
    }
}
