import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> list;

    public Account() {
        balance = 0;
        list = new ArrayList<>();
    }
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }

        this.balance += amount;
        list.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        this.balance -= amount;
        list.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
    }

    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }

        if (operation == Transaction.DEPOSIT) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    public void printTransaction() {
        DecimalFormat format = new DecimalFormat("0.00");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Giao dich " + (i+1) + ": ");
            if (list.get(i).getOperation() == Transaction.DEPOSIT) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            System.out.println(format.format(list.get(i).getAmount()) + ". So du luc nay: $" + format.format(list.get(i).getBalance()) + ".");
        }
    }
}
