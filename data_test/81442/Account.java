import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
            transitionList.add(new Transaction("Nap tien", amount, this.balance));
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.print("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
            transitionList.add(new Transaction("Rut tien", amount, this.balance));
        }
    }

    /**
     *add Transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals("deposit")) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    /**
     * Print History of Transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double a = (double) Math.round(transitionList.get(i).getAmount() * 100) / 100;
            double b = (double) Math.round(transitionList.get(i).getBalance() * 100) / 100;
            System.out.println("Giao dich "
                    + (i + 1)
                    + ": "
                    + transitionList.get(i).getOperation() + " $"
                    + a + ". So du luc nay: $" + b + ".");
        }
    }
}
