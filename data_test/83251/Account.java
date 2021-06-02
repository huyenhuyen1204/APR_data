import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * nap tien.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * rut tien.
     */
    public void withdraw(double amount) {
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

    /**
     * add to transactions.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation.equals("deposit")) deposit(amount);
        if (operation.equals("withdraw")) withdraw(amount);
        if (amount >= 0 && (!operation.equals("withdraw") || amount <= balance))
            transactions.add(new Transaction(operation, amount, balance));
    }

    /**
     * print transactions.
     */
    public void printTransaction() {
        int i = 0;
        for (Transaction s : transactions) {
            i++;
            System.out.println("Giao dich " + i + ": " + s.toString());
        }
    }
}
