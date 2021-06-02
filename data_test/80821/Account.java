import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

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
        } else {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        }
    }

    /**
     * 123.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction transaction = new Transaction("deposit", amount, balance);
            transitionList.add(transaction);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction transaction = new Transaction("withdraw", amount, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * 123.
     */
    public void printTransaction() {
        NumberFormat numberFormatter = new DecimalFormat("#0.00");
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);
            int n = i + 1;
            String operation = null;
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                operation = "Nap tien";
            } else {
                operation = "Rut tien";
            }
            System.out.println("Giao dich " + n + ": " + operation
                    + " $" + numberFormatter.format(transaction.getAmount())
                    + ". So du luc nay: $"
                    + numberFormatter.format(transaction.getBalance())
                    + ".");
        }
    }


}
