import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transitionList;

    Account() {
        this.balance = 0;
        this.transitionList = new ArrayList<Transaction>();
    }

    private void deposit(double amount) {
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw"))
            System.out.println("Yeu cau khong hop le!");
        else {
            if (operation.equals("deposit")) {
                this.deposit(amount);
                this.transitionList.add(new Transaction("deposit", amount, this.balance));
            }
            else {
                this.withdraw(amount);
                this.transitionList.add(new Transaction("withdraw", amount, this.balance));
            }
        }
    }

    public String round(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(value);
    }

    public void printTransaction() {
        for (int i = 0; i < this.transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (this.transitionList.get(i).getOperation().equals("withdraw"))
                System.out.print("Rut tien ");
            else
                System.out.print("Nap tien ");
            System.out.print("$" + round(this.transitionList.get(i).getAmount()) + ". ");
            System.out.println("So du luc nay: $" + round(this.transitionList.get(i).getBalance()) + ".");
        }
    }
}
