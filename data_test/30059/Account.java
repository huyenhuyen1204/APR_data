
import java.util.ArrayList;

public class Account {

    private double balance = 0;

    private ArrayList<Transaction> listTransaction;

    public Account() {
        listTransaction = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
            listTransaction.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount >= this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
            listTransaction.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {

        }
    }

    public void printTransaction() {
        this.balance = Math.round(getBalance() * 100.0) / 100.0;
        
        for (Transaction transaction : listTransaction) {
            double balance = Math.round(transaction.getBalance() * 100.0) / 100.0;
            double amount = Math.round(transaction.getAmount() * 100.0) / 100.0;
            if(transaction.getOperation().equals(Transaction.DEPOSIT)){
                System.out.println("Nap tien $" + amount + ". So du luc nay: $" + balance);
            }else if(transaction.getOperation().equals(Transaction.WITHDRAW)){
                System.out.println("Rut tien $" + amount + ". So du luc nay: $" + balance);
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
