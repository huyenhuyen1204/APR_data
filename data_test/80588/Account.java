import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Loan.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Loan.
     */
    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * Loan.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        }
    }

    /**
     * Loan.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction temp = transitionList.get(i);
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (temp.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            System.out.print((double) Math.round(temp.getAmount() * 100) / 100);
            System.out.print(". So du luc nay: $");
            System.out.print((double) Math.round(temp.getBalance() * 100) / 100);
            System.out.println(".");
        }
    }
}
