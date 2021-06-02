import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account() {}

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
            return;
        }
        if (amount > this.balance) {
            System.out.print("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
    }

    /**
     * add.
     * @param amount giao dich
     * @param operation loai giao dich
     */
    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            System.out.print("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        }
    }

    /**
     * in giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            DecimalFormat df2 = new DecimalFormat("#.00");
            if (transitionList.get(i).getOperation() == (Transaction.DEPOSIT)) {
                this.deposit(transitionList.get(i).getAmount());
                System.out.println("Giao dich " + i + ": " + "Nap tien $"
                + df2.format(transitionList.get(i).getAmount()) + '.'
                + " So du luc nay: $" + df2.format(transitionList.get(i).getBalance()) + '.');
            } else {
                this.withdraw(transitionList.get(i).getAmount());
                System.out.println("Giao dich " + i + ": " + "Rut tien $"
                + df2.format(transitionList.get(i).getAmount()) + '.'
                + " So du luc nay: $" + df2.format(transitionList.get(i).getBalance()) + '.');
            }
        }
    }
}
