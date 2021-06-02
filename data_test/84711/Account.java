import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> list = new ArrayList<>();

    /**
     *bla.
     */
    public Account() {
    }

    /**
     *bla.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     *bla.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     *bla.
     */
    public void addTransaction(double amount, String operation) {
        if(operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            list.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            list.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     *bla.
     */
    public void printTransaction() {
        int i = 1;
        for (Transaction t : list) {
            System.out.print("Giao dich " + i + ": ");
            if (t.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.println("Nap tien $" + t.getAmount() + ". So du luc nay: $"
                        + t.getBalance() + ".");
            } else if (t.getOperation().equals(Transaction.WITHDRAW)) {
                System.out.println("Rut tien $" + t.getAmount() + ". So du luc nay: $"
                        + t.getBalance() + ".");
            }
            i++;
        }
    }

    /**
     *bla.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(1000.26,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}


