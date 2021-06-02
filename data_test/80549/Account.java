import java.util.List;
import java.util.ArrayList;

public class Account {
    private double balance;
    List<String> list = new ArrayList<String>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            list.add("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            String newBalance = round(balance);
            String newAmount = round(amount);
            list.add("Nap tien $" + newAmount + ". So du luc nay: $" + newBalance + ".");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            list.add("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
            String newBalance = round(balance);
            String newAmount = round(amount);
            list.add("Rut tien $" + newAmount + ". So du luc nay: $" + newBalance + ".");
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        }
        if (operation.equals("withdraw")) {
            withdraw(amount);
        }
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            list.add("Yeu cau khong hop le");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + list.get(i));
        }
    }
    public String round(double a)
    {
        return String.format("%.2f", a);
    }
}
