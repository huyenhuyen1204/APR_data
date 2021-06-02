
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * nap tien vao tai khoan.
     * @param amount so tien ban nap.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            Transaction temp = new Transaction(Transaction.DEPOSIT, amount, balance);
            transactionList.add(temp);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * rut tien khoi tai khoan.
     * @param amount so tien ban rut.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
            Transaction temp = new Transaction(Transaction.WITHDRAW, amount, balance);
            transactionList.add(temp);
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        int count = 1;
        for (Transaction iterator : transactionList) {
            System.out.println(String.format("Giao dich %d: %s", count, iterator.toString()));
            count += 1;
        }
    }

}