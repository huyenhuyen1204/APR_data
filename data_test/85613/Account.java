

import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transactionArrayList = new ArrayList<>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    public void addTransaction (double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactionArrayList.add(new Transaction(operation,amount,balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactionArrayList.add(new Transaction(operation,amount,balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 1; i <= transactionArrayList.size(); i++) {
            String s = null;
            if (transactionArrayList.get(i).getOperation().equals("withdraw")) {
                s = "Nap tien";
            }
            if (transactionArrayList.get(i).getOperation().equals("withdraw")) {
                s = "Rut tien";
            }
            System.out.println("Giao dich" + i + ": " + s + "$" +
                                + Math.round(transactionArrayList.get(i).getAmount() * 10) / 10
                                + ". So du luc nay: $" + Math.round(transactionArrayList.get(i).getAmount() * 10) / 10 + ".");
        }
    }
}
