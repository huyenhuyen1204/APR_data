import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * f.
     */
    private void deposit(double amount) {
        if (amount < 0 || amount == 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * f.
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount < 0) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * h.
     */
    public void addTransaction(double amount, String operation) {

        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transitionList.add(t);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transitionList.add(t);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }

    /**
     * d.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            DecimalFormat d = new DecimalFormat("#.00#");
            double money = (double) Math.round(transitionList.get(i).getAmount() * 100) / 100;
            System.out.print(d.format(money) + ". So du luc nay: $");
            double moneyy = (double) Math.round(transitionList.get(i).getBalance() * 10) / 10;
            System.out.println(moneyy + ".");
        }
    }
}
