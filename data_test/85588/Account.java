import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

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
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * Add.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            this.deposit(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            this.withdraw(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                String s = String.format("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.",
                        i + 1, transitionList.get(i).getAmount(),
                        transitionList.get(i).getBalance());
                System.out.println(s);
            } else {
                String s = String.format("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.",
                        i + 1, transitionList.get(i).getAmount(),
                        transitionList.get(i).getBalance());
                System.out.println(s);
            }
        }
    }
}
