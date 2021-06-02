import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance = balance + amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
        }
    }

    /**
     * Trang.
     */
    public void addTransaction(double amount, String operation) {
        if ((operation.equalsIgnoreCase(Transaction.DEPOSIT)) == true) {
            deposit(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transactionList.add(t);
        } else if ((operation.equalsIgnoreCase(Transaction.WITHDRAW)) == true) {
            withdraw(amount);
            Transaction t = new Transaction(operation, amount, balance);
            transactionList.add(t);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Trang.
     */
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            if ((transactionList.get(i).getOperation().equalsIgnoreCase(Transaction.DEPOSIT)) == true) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        (i + 1), (double) Math.round(transactionList.get(i).getAmount() * 100) / 100,
                        (double) Math.round(transactionList.get(i).getBalance() * 100) / 100);
            } else if ((transactionList.get(i).getOperation().equalsIgnoreCase(Transaction.WITHDRAW)) == true) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        (i + 1), (double) Math.round(transactionList.get(i).getAmount() * 100) / 100,
                        (double) Math.round(transactionList.get(i).getBalance() * 100) / 100);
            }
        }
    }

}
