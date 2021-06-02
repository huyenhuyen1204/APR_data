import java.util.ArrayList;
import java.util.List;

public class Account {
    private Transaction transaction;
    private double balance;
    private List<Transaction>  list = new ArrayList<>();

    // give money
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            balance += amount;
        }
    }

    // take money
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else {
            balance -= amount;
        }
    }

    /**
     * Print transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (list.get(i).getOperation() == "withdraw") {
                System.out.print("Rut tien $" + String.format("%.2f", list.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f",list.get(i).getBalance()) + ".");
            }
            else if (list.get(i).getOperation() == "deposit") {
                System.out.print("Nap tien $" + String.format("%.2f", list.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f",list.get(i).getBalance()) + ".");
            }
        }
    }

    /**
     * Add transaction.
     * @param amount is amount
     * @param operation is operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation == "deposit") {
            deposit(amount);
        }
        else if (operation == "withdraw") {
            withdraw(amount);
        }
        else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

}
