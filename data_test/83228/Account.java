import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    List <String> giaoDich = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            String tmp = "Nap tien $" + String.valueOf((double) Math.round(amount * 100) / 100)
                    + ". So du luc nay: $" + String.valueOf((double) Math.round((balance + amount) * 100) / 100) + ".";
            giaoDich.add(tmp);
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du");
        } else {
            String tmp = "Rut tien $" + String.valueOf((double) Math.round(amount * 100) / 100)
                    + ". So du luc nay: $" + String.valueOf((double) Math.round((balance - amount) * 100) / 100) + ".";
            giaoDich.add(tmp);
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < giaoDich.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + giaoDich.get(i));
        }
    }

}
