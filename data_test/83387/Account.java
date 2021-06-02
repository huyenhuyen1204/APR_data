import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;

    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * Method add.
     */

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            if (amount > 0) {
                balance = balance + amount;
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            }

        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            if (amount <= balance) {
                balance = balance - amount;
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Method print.
     */

    public void printTransaction() {
        DecimalFormat format = new DecimalFormat("##.##");
        for (int i = 0; i < transitionList.size(); i++) {
            String res = "";
            res = res + transitionList.get(i).getOperation();
            if (res.equals(Transaction.DEPOSIT)) {
                System.out.print("Giao dich " + (i + 1) + ": Nap tien $"
                        + format.format(transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + format.format(transitionList.get(i).getBalance()) + ".\n");
            } else if (res.equals(Transaction.WITHDRAW)) {
                System.out.print("Giao dich " + (i + 1) + ": Rut tien $"
                        + format.format(transitionList.get(i).getAmount())
                        + ". So du luc nay: $"
                        + format.format(transitionList.get(i).getBalance()) + ".\n");
            }
        }
    }
}
