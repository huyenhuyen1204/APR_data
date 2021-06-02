import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Account {
    private double balance = 0; // So du
    private List<Transaction> transitionList2 = new ArrayList<Transaction>();
    private ArrayList<Transaction> transitionList;

    private void deposit(double amount) {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else this.balance += amount;
    }

    private void withdraw(double amount) {
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else
            if(amount > balance) System.out.println("So tien ban rut vuot qua so du!");
            else this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            this.deposit(amount);
            this.transitionList2.add(new Transaction("deposit", amount, this.balance));
            return;
        }
        if (operation.equals("withdraw")) {
            this.withdraw(amount);
            this.transitionList2.add(new Transaction("withdraw", amount, this.balance));
            return;
        }
        System.out.println("Yeu cau khong hop le!");

    }

    public void printTransaction() {
        DecimalFormat df = new DecimalFormat("#.00");

        int count = 1;

        for (Transaction trans: transitionList2) {
            System.out.print("Giao dich " + count + ": ");
            if (trans.getOperation().equals("deposit"))
                System.out.print("Nap tien ");
            if (trans.getOperation().equals("withdraw"))
                System.out.print("Rut tien ");
            System.out.println("$" + df.format(trans.getAmount())
                    + ". So du luc nay: $" + df.format(trans.getBalance())+ ".");
            count++;
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.25, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
