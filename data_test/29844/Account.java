import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList;

    Account() {
        this.balance = 0;
        this.transactionList = new ArrayList<Transaction>();
    }

    private void deposit(double amount) {
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance)
            System.out.println("So tien ban rut vuot qua so su!");
        else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw"))
            System.out.println("Yeu cau khong hop le!");
        else {
            if (operation.equals("deposit")) {
                this.deposit(amount);
                this.transactionList.add(new Transaction("deposit", amount, this.balance));
            }
            else {
                this.withdraw(amount);
                this.transactionList.add(new Transaction("withdraw", amount, this.balance));
            }
        }
    }

    public double round(double value, int precision) {
        return (double) Math.round(value * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public void printTransaction() {
        for (int i = 0; i < this.transactionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (this.transactionList.get(i).getOperation().equals("withdraw"))
                System.out.print("Rut tien ");
            else
                System.out.print("Nap tien ");
            System.out.print("$" + round(this.transactionList.get(i).getAmount(), 2) + ". ");
            System.out.println("So du luc nay: $" + round(this.transactionList.get(i).getBalance(), 2) + ".");
        }
    }
}
