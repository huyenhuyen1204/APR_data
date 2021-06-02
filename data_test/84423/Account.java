import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> list = new ArrayList<>();

    public Account() {

    }
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance = this.balance + amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        this.balance = this.balance - amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            this.deposit(amount);
            if (amount > 0) {
                Transaction transaction
                        = new Transaction("Nap tien", amount, this.balance);
                this.list.add(transaction);
            }
            return;
        }
        if (operation.equals("withdraw")) {
            this.withdraw(amount);
            if (amount > 0 && amount <= this.balance) {
                Transaction transaction
                        = new Transaction("Rut tien", amount, this.balance);
                this.list.add(transaction);
            }
            return;
        }
        System.out.println("Yeu cau khong hop le!");
    }

    public String rounding(double x) {
        x = (double) Math.round(x * 100) / 100;
        return String.format("%.2f", x);
    }

    public void printTransaction() {
        for (int i = 0; i < this.list.size(); i++) {
            Transaction transaction = this.list.get(i);
            String text = "";
            text += "Giao dich " + (i + 1) + ": " + transaction.getOperation();
            text += " $" + this.rounding(transaction.getAmount()) + ". ";
            text += "So du luc nay: $" + this.rounding(transaction.getBalance()) + ".";
            System.out.println(text);
        }
    }


}
