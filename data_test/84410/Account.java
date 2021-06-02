import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance = balance + amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
        }
    }

    /**
     * Add.
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
     * Print.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            DecimalFormat format = new DecimalFormat("0.00");
            String output = "Giao dich " + (i + 1) + ": ";
            Transaction transaction = transitionList.get(i);
            double amount = (double) Math.round(transaction.getAmount() * 100) / 100;
            double balance = (double) Math.round(transaction.getBalance() * 100) / 100;
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                output = output
                        + "Nap tien $"
                        + format.format(amount)
                        + ". So du luc nay: $"
                        + format.format(balance)
                        + ".";
            }
            if (transaction.getOperation().equals(Transaction.WITHDRAW)) {
                output = output
                        + "Rut tien $"
                        + format.format(amount)
                        + ". So du luc nay: $"
                        + format.format(balance)
                        + ".";
            }
            System.out.println(output);
        }
    }

    public ArrayList<Transaction> getTransitionList() {
        return transitionList;
    }

    public void setTransitionList(ArrayList<Transaction> transitionList) {
        this.transitionList = transitionList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

 