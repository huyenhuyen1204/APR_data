import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private List<Transaction> transactionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            transactionList.add(transaction);
            return;
        }
        System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            transactionList.add(transaction);
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size() - 1; i++) {
            if (transactionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.println("Giao dich " + i + ": Nap tien $ " + round(transactionList.get(i).getAmount())
                        + ". So du luc nay: $" + round(transactionList.get(i).getBalance()) + ".");
            } else {
                System.out.println("Giao dich " + i + ": Rut tien $ " + round(transactionList.get(i).getAmount())
                        + ". So du luc nay: $" + round(transactionList.get(i).getBalance()) + ".");
            }
        }
    }

    private double round(double n) {
        n = (int) (n * 100 + 0.5);
        n /= 100;
        return n;
    }
}
