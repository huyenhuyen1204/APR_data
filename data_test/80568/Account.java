import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();
    private ArrayList<String> list = new ArrayList<String>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            String newBalance = round(balance);
            String newAmount = round(amount);
            list.add("Nap tien $" + newAmount + ". So du luc nay: $" + newBalance + ".");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            String newBalance = round(balance);
            String newAmount = round(amount);
            list.add("Rut tien $" + newAmount + ". So du luc nay: $" + newBalance + ".");
        }
    }

    /**
     * narutooooo.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        }
        if (operation.equals("withdraw")) {
            withdraw(amount);
        }
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * sasukeeeeee.
     */
    public void printTransaction() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + list.get(i));
        }
    }

    public String round(double a) {
        return String.format("%.2f", a);
    }
}
