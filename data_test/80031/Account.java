import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**nap.*/
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**rut.*/
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**addTrans.*/
    public void addTransaction(double amount, String operation) {
        Transaction trans;
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            balance += amount;
            trans = new Transaction(operation, amount, balance);
            transitionList.add(trans);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            balance -= amount;
            trans = new Transaction(operation, amount, balance);
            transitionList.add(trans);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**print.*/
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                        + dfRound(transitionList.get(i).getAmount()) + ". So du luc nay: $"
                        + dfRound(transitionList.get(i).getBalance()) + ".");
            } else {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $"
                        + dfRound(transitionList.get(i).getAmount()) + ". So du luc nay: $"
                        + dfRound(transitionList.get(i).getBalance()) + ".");
            }
        }
    }

    /**dfRound.*/
    public String dfRound(double num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }
}
