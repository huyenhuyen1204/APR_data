import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void Account() {
        balance = 0;
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (balance > amount) {
            if (amount > 0) {
                balance = balance - amount;
            } else {
                System.out.println("So tien ban rut ra khong hop le!");
            }
        } else {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    public void addTransaction(double amount, String operation) {
        Transaction transaction = new Transaction(operation, amount, balance);
        if (operation == transaction.DEPOSIT) {
            deposit(amount);
            transaction.setBalance(balance);
            transactions.add(transaction);
        } else if (operation == transaction.WITHDRAW) {
            withdraw(amount);
            transaction.setBalance(balance);
            transactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            double amounts = transactions.get(i).getAmount();
            amounts = Math.round(amounts * 100);
            amounts = amounts / 100;
            double balances = transactions.get(i).getBalance();
            balances = Math.round(balances * 100);
            balances = balances / 100;
            if (transactions.get(i).getOperation() == transactions.get(i).DEPOSIT) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay : $%.2f.", i + 1, amounts, balances);
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay : $%.2f.", i + 1, amounts, balances);
            }
            System.out.println();
        }
    }
}
