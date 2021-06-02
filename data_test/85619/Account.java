

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account() {

    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance = balance + amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance = this.balance - amount;
        }
    }

    /**
     * comment.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * comment.
     */
    public void printTransaction() {
        for (int i = 1; i <= transitionList.size(); i++) {
            String s = null;
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                s = "Nap tien";
            }
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                s = "Rut tien";
            }
            System.out.println("Giao dich" + i + ": " + s + "$"
                    + Math.round(transitionList.get(i).getAmount() * 10) / 10
                    + ". So du luc nay: $"
                    + Math.round(transitionList.get(i).getAmount() * 10) / 10
                    + ".");
        }
    }
}
