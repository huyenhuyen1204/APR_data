
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private double deposit;
    private double withdraw;
    private ArrayList<Transaction> transitionList;

    /**
     * cmt.
     */
    public Account() {
        this.balance = 0;
        this.transitionList = new ArrayList<>();
    }

    /**
     * cmt.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance += amount;
    }

    /**
     * cmt.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        this.balance -= amount;
    }

    /**
     * cmt.
     */
    public void addTransaction(double amount, String str) {
        if (str.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            this.transitionList.add(new Transaction(str, amount, this.balance));
        } else if (str.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            this.transitionList.add(new Transaction(str, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * cmt.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String str;
            Transaction transaction = transitionList.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                str = " Nap tien $";
            } else {
                str = " Rut tien $";
            }
            double num1 = (double) Math.round(transaction.getAmount() * 100) / 100;
            double num2 = (double) Math.round(transaction.getBalance() * 100) / 100;
            System.out.printf("Giao dich %d:%s%.2f. So du luc nay: $%.2f.\n"
                    , (i + 1), str, num1, num2);
        }
    }
}
 