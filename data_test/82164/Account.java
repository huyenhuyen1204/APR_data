import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }
    /**....*/

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            transitionList.add(new Transaction("deposit", amount, balance));
            return;
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            transitionList.add(new Transaction("withdraw", amount, balance));
            return;
        } else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
    }
    /**....*/

    public void printTransaction() {
        int len = transitionList.size();
        DecimalFormat format = new DecimalFormat("0.00");
        for (int i = 0; i < len; i++) {
            String t = "";
            if (transitionList.get(i).getOperation().equals("deposit")) {
                t += "Nap tien $"
                  + format.format(Math.round(transitionList.get(i).getAmount() * 10 * 10) / 100.00)
                  + ". " + "So du luc nay: $"
                  + format.format(Math.round(transitionList.get(i).getBalance()
                        * 10 * 10) / 100.00)
                        + "."
                ;
            } else {
                t += "Rut tien $"
                        + format.format(Math.round(transitionList.get(i).getAmount()
                        * 10 * 10) / 100.00)
                        + ". " + "So du luc nay: $"
                        + format.format(Math.round(transitionList.get(i).getBalance()
                        * 10 * 10) / 100.00) + "."
                ;
            }
            System.out.println("Giao dich " + (i + 1) + ": " + t);
        }
    }
}
