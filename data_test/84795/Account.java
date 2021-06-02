import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The type Account.
 */
public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList;
    private static DecimalFormat df = new DecimalFormat("0.00");


    /**
     * Instantiates a new Account.
     */
    public Account() {
        transitionList = new ArrayList<Transaction>();
    }

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
     * Add transaction.
     *
     * @param amount    the amount
     * @param operation the operation
     */
    public void addTransaction(double amount, String operation ) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
                transitionList.add(new Transaction(operation, amount, balance));
            } else {
                withdraw(amount);
                transitionList.add(new Transaction(operation, amount, balance));
            }
        }
    }

    /**
     * Print transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String s;
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                s = ": Nap tien ";
            } else {
                s = " Rut tien ";
            }

            System.out.println("Giao dich "
                    + (i + 1)
                    + s
                    + "$"
                    + df.format(transitionList.get(i).getAmount())
                    + ". So du luc nay: $"
                    + df.format(transitionList.get(i).getBalance())
                    + "."
            );
        }
    }
}
