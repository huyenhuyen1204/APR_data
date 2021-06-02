
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance = balance + amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
        }
    }

    /**
     * comment.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * comment.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String s = null;
            if (transitionList.get(i).getOperation().equals("deposit")) {
                s = "Nap tien";
            }
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                s = "Rut tien";
            }
            System.out.println("Giao dich " + (i + 1) + ": " + s + " $"
                    + decimalFormat.format(transitionList.get(i).getAmount())
                    + ". So du luc nay: $"
                    + decimalFormat.format(transitionList.get(i).getBalance())
                    + ".");
        }
    }
}
