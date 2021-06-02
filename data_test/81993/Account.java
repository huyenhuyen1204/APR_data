import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    List<Transaction> historyTransaction = new ArrayList<>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation == "deposit") {
            this.deposit(amount);
            if (amount > 0) {
                Transaction transaction
                        = new Transaction("Nap tien", amount, this.balance);
                this.historyTransaction.add(transaction);
            }
            return;
        }
        if (operation == "withdraw") {
            this.withdraw(amount);
            if (amount > 0 && amount <= this.balance) {
                Transaction transaction
                        = new Transaction("Rut tien", amount, this.balance);
                this.historyTransaction.add(transaction);
            }
            return;
        }
        System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i = 0; i < this.historyTransaction.size(); i++) {
            Transaction transaction = this.historyTransaction.get(i);
            String text = "";
            text += "Giao dich " + (i + 1) + ": " + transaction.getOperation();
            text += " $" + this.approximately(transaction.getAmount()) + ". ";
            text += "So du luc nay: $" + this.approximately(transaction.getBalance()) + ".";
            System.out.println(text);
        }
    }

    public String approximately(double x) {
        x = (double) Math.round(x * 100) / 100;
        return String.format("%.2f", x);
    }
}
