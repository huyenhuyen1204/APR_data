import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<String> Type = new ArrayList<>();
    private List<Double> Amount = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
            Type.add("Nap tien");
            Amount.add(amount);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.print("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
            Type.add("Rut tien");
            Amount.add(amount);
        }
    }

    /**
     *add Transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals("deposit")) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    /**
     * Print History of Transaction
     */
    public void printTransaction() {
        for (int i = 0; i < Type.size(); i++) {
            double a = Math.round(Amount.get(i) * 100) / 100;
            double b = Math.round(this.balance * 100) / 100;
            System.out.println("Giao dich " + (i + 1) + ": " + Type.get(i) + " "
                    + a + ". So du luc nay: " + b + ".");
        }
    }
}
