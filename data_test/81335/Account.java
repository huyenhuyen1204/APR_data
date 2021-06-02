import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private final ArrayList<Transaction> history;
    private double balance;

    /**
     * .
     */
    public Account() {
        this.balance = 0;
        this.history = new ArrayList<Transaction>();
    }

    /**
     * .
     *
     * @param amount .
     */
    private void deposit(double amount) {
        balance += amount;
    }

    /**
     * .
     *
     * @param amount .
     */
    private void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * .
     *
     * @param amount    .
     * @param operation .
     */
    void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.in.toLowerCase()) &&
                !operation.equals(Transaction.out.toLowerCase())) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation.equals(Transaction.in.toLowerCase())) {
            if (amount <= 0) {
                System.out.println("So tien ban nap vao khong hop le!");
                return;
            }
            deposit(amount);
        } else {
            if (amount <= 0) {
                System.out.println("So tien ban rut ra khong hop le!");
                return;
            }
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
                return;
            }
            withdraw(amount);
        }
        Transaction transaction = new Transaction(operation, amount, this.balance);
        history.add(transaction);
    }

    /**
     * .
     */
    public void printTransaction() {
        int length = this.history.size();
        for (int i = 1; i <= length; i++) {
            Transaction trans = history.get(i - 1);
            StringBuffer s = new StringBuffer("Giao dich ");
            s.append(i);
            if (trans.getOperation().equals("deposit")) {
                s.append(": Nap tien $");
            } else {
                s.append(": Rut tien $");
            }
            DecimalFormat df = new DecimalFormat("#.00");
            double temp = (double) Math.round(trans.getAmount() * 100) / 100;
            String amount = df.format(temp);
            s.append(amount);
            s.append(". So du luc nay: $");
            double temp2 = (double) Math.round(trans.getBalance() * 100) / 100;
            String balance = df.format(temp2);
            s.append(balance);
            s.append(".");
            System.out.println(s);
        }
    }
}
