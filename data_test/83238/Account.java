import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private List <Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            String tmp = "Nap tien $" + String.format("%.2f", amount)
                    + ". So du luc nay: $" + String.format("%.2f", amount + balance) + ".";
            tmp = tmp.replace(',', '.');

            Transaction tmpT = new Transaction();
            tmpT.cheat = tmp;
            transitionList.add(tmpT);
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            String tmp = "Rut tien $" + String.format("%.2f", amount)
                    + ". So du luc nay: $" + String.format("%.2f", balance - amount) + ".";
            tmp = tmp.replace(',', '.');

            Transaction tmpT = new Transaction();
            tmpT.cheat = tmp;
            transitionList.add(tmpT);

            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i).cheat);
        }
    }

}
