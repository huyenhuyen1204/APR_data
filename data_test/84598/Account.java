import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionArrayList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            setBalance(getBalance() + amount);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            if (amount > 0) {
                deposit(amount);
                Transaction transaction = new Transaction("Nap tien",
                        (double) Math.round(amount * 100)/ 100,
                        (double) Math.round(getBalance() * 100) / 100);
                transactionArrayList.add(transaction);
            } else {
                deposit(amount);
            }
        } else if (operation.equals(Transaction.WITHDRAW)) {
            if (amount > 0 && amount < getBalance()) {
                withdraw(amount);
                Transaction transaction2 = new Transaction("Rut tien",
                        (double) Math.round(amount * 100) / 100,
                        (double) Math.round(getBalance() * 100) / 100);
                transactionArrayList.add(transaction2);
            } else {
                withdraw(amount);
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactionArrayList.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": "
                    + transactionArrayList.get(i).getOperation() + " $" + transactionArrayList.get(i).getAmount()
                    + ". " + "So du luc nay: " + "$" + transactionArrayList.get(i).getBalance() + ".");
        }
    }
}
