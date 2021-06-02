

import java.util.ArrayList;


public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;

        }
    }

    /**
     * addTransaction.
     */
    public void addTransaction(double a, String o) {
        if (o.equals(Transaction.DEPOSIT) == true) {
            deposit(a);
            Transaction transaction = new Transaction(o, a, balance);
            transitionList.add(transaction);
        } else if (o.equals(Transaction.WITHDRAW) == true) {
            withdraw(a);
            Transaction transaction = new Transaction(o, a, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }

    /**
     * withdraw.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;

        }
    }

    /**
     * round.
     */
    private String round(double number) {
        String str = "";
        double number1 = (double) Math.round(number * 100) / 100;

        if (number - (int) number == 0) {
            str = String.valueOf((int) number) + ".00";
        } else {
            str = String.valueOf(number1);
        }
        return str;
    }

    /**
     * printTransaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String str = "";
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                str = "Nap tien";
            } else {
                str = "Rut tien";
            }
            System.out.println("Giao dich " + (i + 1) + ": " + str + " $"
                    + round(transitionList.get(i).getAmount()) + ". So du luc nay: $"
                    + round(transitionList.get(i).getBalance()) + ".");
        }
    }
}
