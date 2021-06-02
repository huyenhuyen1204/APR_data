import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList;

    public Account() {}

    public double getBalance() {
        return balance;
    }

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
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setOperation(operation);
            transactionList.add(transaction);
        }
    }

    /**
     * in giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            DecimalFormat df2 = new DecimalFormat("#.00");
            if (transactionList.get(i).getOperation() == Transaction.DEPOSIT) {
                this.deposit(transactionList.get(i).getAmount());
                System.out.println("Giao dich " + i + ": " + "Nap tien $"
                + df2.format(transactionList.get(i).getAmount()) + '.'
                + " So du luc nay: $" + df2.format(getBalance()) + '.');
            } else {
                this.withdraw(transactionList.get(i).getAmount());
                System.out.println("Giao dich " + i + ": " + "Rut tien $"
                + df2.format(transactionList.get(i).getAmount()) + '.'
                + " So du luc nay: $" + df2.format(getBalance()) + '.');
            }
        }
    }
}
