import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }

        this.balance += amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        this.balance -= amount;
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
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
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i+1) + ": ");
            if (transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            System.out.println(format.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + format.format(transitionList.get(i).getBalance()) + ".");
        }
    }
}
