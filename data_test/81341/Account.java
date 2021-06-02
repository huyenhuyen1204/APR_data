import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;

public class Account {
    private double balance;
    ArrayList<Transaction> arr;

    public Account() {
        this.balance = 0;
        this.arr = new ArrayList<>();;
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals("deposit")) {
            deposit(amount);
            arr.add(new Transaction("Nap tien ", amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            arr.add(new Transaction("Rut tien ", amount, balance));
        }
    }

    public void printTransaction() {
        String print = ". So du luc nay: $";
        int n = arr.size();
        Transaction transaction;
        String s;
        double amount;
        double balance;
        for (int i = 0; i < n; i++) {
            transaction = arr.get(i);
            s = transaction.getOperation();
            amount = (double) Math.round(transaction.getAmount() * 100) / 100;
            balance = (double) Math.round(transaction.getBalance() * 100) / 100;
            System.out.println("Giao dich " + (i + 1) + ": " + s + "$" + amount +
                            print + balance + ".");
        }
        double x = 432.312321312312;
        System.out.println((double) Math.round(x*100)/100);
    }
}
