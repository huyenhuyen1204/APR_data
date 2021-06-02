import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;
    private List<Transaction>  list = new ArrayList<>();

    // give money
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    // take money
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * Add transaction.
     * @param amount is amount
     * @param operation is operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            list.add(new Transaction(operation, amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            list.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print transaction.
     */
    public void printTransaction() {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print("Giao dich " + i + ": ");
            if (list.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien $" + String.format("%.2f", list.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", list.get(i).getBalance()) + ".");
            } else if (list.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $" + String.format("%.2f", list.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", list.get(i).getBalance()) + ".");
            }
        }
    }
}
