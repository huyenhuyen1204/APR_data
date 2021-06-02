//package Transaction;

import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else {
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            transitionList.add(new Transaction("deposit", amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            transitionList.add(new Transaction("withdraw", amount, balance));
        } else
            System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        int i = 1;
        for (Transaction transaction: transitionList) {
            String type = "";
            if (transaction.getOperation().equals("deposit"))
                type = "Nap tien";
            else type = "Rut tien";
            System.out.println("Giao dich " + (i++) + ": " + type + " $" + (double) Math.round(transaction.getAmount()*100)/100 + ". So du luc nay: $" + (double) Math.round(transaction.getBalance()*100)/100 + ".");
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
