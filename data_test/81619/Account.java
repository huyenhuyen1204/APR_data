import java.text.DecimalFormat;
import java.util.ArrayList;


public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();


    /**
     * nap tien.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * rut tien.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * them giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT)
                && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else if (operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
            }
            transitionList.add(new Transaction(operation, amount, balance));
        }
    }

    /**
     * in giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String p = "";
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                p = ": Nap tien $";
            }
            if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                p = ": Rut tien $";
            }
            int x = i + 1;
            DecimalFormat dcf = new DecimalFormat("########.00");
            System.out.println("Giao dich " + x + p
                    + dcf.format(transitionList.get(i).getAmount())
                    + ". So du luc nay: $" + dcf.format(transitionList.get(i).getBalance()) + ".");
        }
    }

}
