import java.util.ArrayList;

public class Account {
    private double balance;
    private final ArrayList<Transaction> transactions;

    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * abcdef.
     */
    public void addTransaction(double amount, String operation) {

        if (operation.equals("deposit")) {
            this.deposit(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transactions.add(transaction);
        } else if (operation.equals("withdraw")) {
            this.withdraw(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * ok.
     */
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); ++i) {
            System.out.println("Giao dich " + (i + 1) + ": " + transactions.get(i).toString());
        }
    }

}
  