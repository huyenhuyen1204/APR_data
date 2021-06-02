
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private double deposit;
    private double withdraw;
    private List<Transaction> listTransaction;

    public Account() {
        this.balance = 0;
        this.listTransaction = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            this.listTransaction.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            this.listTransaction.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < listTransaction.size(); i++) {
            String operation;
            Transaction transaction = listTransaction.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                operation = " Nap tien $";
            } else {
                operation = " Rut tien $";
            }
            //Giao dich 1: Nap tien $2000.26. So du luc nay: $2000.26.
            double a = (double) Math.round(transaction.getAmount() * 100) / 100;
            double b = (double) Math.round(transaction.getBalance() * 100) / 100;
            System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.",(i+1),a,b);
        }
    }

    public static void main(String[] args) {
    
    }
}
