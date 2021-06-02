import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction>  transitionList = new ArrayList<>();

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
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien $"
                        + String.format("%.2f", transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", transitionList.get(i).getBalance()) + ".");
            } else if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $"
                        + String.format("%.2f", transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + String.format("%.2f", transitionList.get(i).getBalance()) + ".");
            }
            System.out.print("\n");
        }
    }
}
