import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transaction = new ArrayList<>();

    /**
     * nap tien.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    /**
     * rut tien.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * them giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.operation1)) {
            deposit(amount);
            transaction.add(new Transaction(operation, amount, balance));
        } else if (operation.equalsIgnoreCase(Transaction.operation2)) {
            withdraw(amount);
            transaction.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * in giao dich.
     */
    public void printTransaction() {
        int i = 1;
        DecimalFormat f = new DecimalFormat("##.00");
        for (Transaction t : transaction) {
            if (t.getOperation().equalsIgnoreCase(Transaction.operation1)) {
                System.out.println("Giao dich " + i + ": Nap tien $" + f.format(t.getAmount())
                        + ". So du luc nay: $" + f.format(t.getBalance()) + ".");
            } else {
                System.out.println("Giao dich " + i + ": Rut tien $" + f.format(t.getAmount())
                        + ". So du luc nay: $" + f.format(t.getBalance()) + ".");
            }
            i++;
        }
    }

    /**
     * args.
     */
    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
