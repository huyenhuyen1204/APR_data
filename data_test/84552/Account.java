
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    ;

    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount < 0) {
            System.out.println(" So tien ban rut ra khong hop le!");
        } else if (amount > 0) {
            balance = balance - amount;
        }
    }

    /**
     * them.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transitionList.add(t);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transitionList.add(t);
        }
    }

    /**
     * in.
     */
    public void printTransaction() {
        int i = 0;
        for (Transaction tr : transitionList) {
            i++;
            if (tr.getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (i) + ": Nap tien" + tr.toString());
            } else if (tr.getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (i) + ": Rut tien" + tr.toString());
            }
        }
    }
}



