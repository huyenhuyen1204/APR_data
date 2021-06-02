
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> operations;

    public Account() {
        balance = 0.0;
        operations = new ArrayList<>();
    }

    private void Err(String error) {
        System.out.println(error);
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            Err("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            Err("So tien ban nap vao khong hop le!");
            return;
        }
        if (amount > balance) {
            Err("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }

    public void addTransaction(double amount, String operation) {

        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            operations.add(new Transaction(operation, amount, balance));
            return;
        }

        if (operation.equals(Transaction.WITHDRAW)) {
            operations.add(new Transaction(operation, amount, balance));
            withdraw(amount);
            return;
        }
        Err("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i = 0; i < operations.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + operations.get(i).toString());
        }
    }
}
