import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    /**
     * constructor.
     */
    public Account() {
        transitionList = new ArrayList<Transaction>();
    }

    /**
     * phương thức gọi khi nạp tiền.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        }
    }

    /**
     * phương thức gọi khi rút tiền.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
        }
    }

    /**
     * phương thức gọi khi có giao dịch.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * phương thức in ra các giao dịch.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f."
                        , i + 1, transitionList.get(i).getAmount());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f."
                        , i + 1, transitionList.get(i).getAmount());
            }
            System.out.printf(" So du luc nay: $%.2f.\n", transitionList.get(i).getBalance());
        }
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.addTransaction(2000, "withdraw");
        acc.printTransaction();

    }
}
