import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Luong .
     */
    private void deposit(double money) {
        if (money > 0) {
            balance = balance + money;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Withdraw .
     */
    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * Ham .
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        }
    }

    /**
     * Ham .
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transaction.getOperation().equals(Transaction.WITHDRAW)) {
                System.out.print("Rut tien $");
            } else {
                System.out.print("Nap tien $");
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.00#");
            double tien1 = (double) Math.round(transaction.getAmount() * 100) / 100;
            System.out.print(decimalFormat.format(tien1));
            System.out.print(". So du luc nay: $");
            double tien2 = (double) Math.round(transaction.getBalance() * 100) / 100;
            System.out.print(decimalFormat.format(tien2));
            System.out.println(".");
        }
    }
}
