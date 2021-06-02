
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        balance = 0.0;
        transitionList = new ArrayList<>();
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
            transitionList.add(new Transaction(operation, amount, balance));
            return;
        }

        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
            return;
        }
        Err("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i).toString());
        }
    }
}
