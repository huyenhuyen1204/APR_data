import java.util.ArrayList;

/**
 * Created by Minology on 11:35 SA
 */
public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private void deposit(double amount) {
        if (amount <= 1e-8) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 1e-8) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW){
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        double currentBalance = balance;
        if (operation == Transaction.DEPOSIT) {
            deposit(amount);
        }
        else {
            withdraw(amount);
        }
        if (Math.abs(balance - currentBalance) > 0)
            transitionList.add(new Transaction(operation, amount, balance));
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); ++i) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                System.out.print("Nap tien $");
            }
            else {
                System.out.print("Rut tien $");
            }
            String s1 = Double.toString(Math.round((transitionList.get(i).getAmount() + 1e-8) * 100) / 100.00);
            String s2 = Double.toString(Math.round((transitionList.get(i).getBalance() + 1e-8) * 100) / 100.00);
            if (s1.charAt(s1.length() - 3) != '.') s1 = s1.concat("0");
            if (s2.charAt(s2.length() - 3) != '.') s2 = s2.concat("0");
            System.out.println(s1 + ". So du luc nay: $" + s2 + ".");
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(-1,"deposit");
        acc.addTransaction(-1,"withdraw");
        acc.addTransaction(1000,"withdraw");
        acc.addTransaction(562, "deposit");
        acc.printTransaction();
    }
}
