import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0; // So du
    private List<Transaction> transactions = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else this.balance += amount;
    }

    private void withdraw(double amount) {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else
            if(amount > balance) System.out.println("So tien ban rut vuot qua so du");
            else this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            this.deposit(amount);
            this.transactions.add(new Transaction("deposit", amount, this.balance));
            return;
        }
        if (operation.equals("withdraw")) {
            this.withdraw(amount);
            this.transactions.add(new Transaction("withdraw", amount, this.balance));
            return;
        }
        System.out.println("Yeu cau khong hop le!");

    }

    public void printTransaction() {
        for (Transaction trans: transactions) {
            if (trans.getOperation().equals("deposit"))
                System.out.print("Nap tien ");
            if (trans.getOperation().equals("withdraw"))
                System.out.print("Rut tien ");
            System.out.println("$" + (double)((int)(trans.getAmount() * 100)) / 100
                    + ". So du luc nay: $" + (double)((int)(trans.getBalance() * 100)) / 100);
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.25, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
