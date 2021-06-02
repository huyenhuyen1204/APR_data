import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /** binhDang. */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** binhDang. */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /** binhDang. */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction("deposit", amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction("withdraw", amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** binhDang. */
    public void printTransaction() {
        DecimalFormat df = new DecimalFormat("#.00#");
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien $");
            } else {
                System.out.print("Nap tien $");
            }
            double temp1 = transitionList.get(i).getAmount();
            if (temp1 == (int) temp1) {
                System.out.print(df.format(temp1));
            } else {
                System.out.print((double) Math.round(temp1 * 100) / 100);
            }
            System.out.print(". So du luc nay: $");
            double temp2 = transitionList.get(i).getBalance();
            if (temp2 == (int) temp2) {
                System.out.print(df.format(temp2));
            } else {
                System.out.print((double) Math.round(temp2 * 100) / 100);
            }
            System.out.println(".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
