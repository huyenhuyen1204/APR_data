import java.util.ArrayList;

/* java String.format("%.2f", input). */

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": "
                    + transactions.get(i).toString());
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            if (amount < 0) {
                System.out.println("So tien ban nap vao khong hop le!");
                return;
            }
            balance = balance + amount;
            Transaction transaction = new Transaction();
            transaction.setOperation(operation);
            transaction.setAmount(amount);
            transaction.setBalance(balance);
            transactions.add(transaction);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
                return;
            } else if (amount < 0) {
                System.out.println("So tien ban rut ra khong hop le!");
                return;
            }
            balance = balance - amount;
            Transaction transaction = new Transaction();
            transaction.setOperation(operation);
            transaction.setAmount(amount);
            transaction.setBalance(balance);
            transactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    private void deposit(double amount) {

    }

    private void withdraw(double amount) {

    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
