import java.util.ArrayList;

public class Account {

    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Comment.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * Comment.
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
     * Comment.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT) || operation.equals(Transaction.WITHDRAW)) {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Comment.
     */
    public void printTransaction() {
        for (int i = 1; i <= transitionList.size(); i++) {
            System.out.println("Giao dich " + i + ": " + transitionList.get(i - 1).getInfo());
        }
    }

}
