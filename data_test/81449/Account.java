/**
 * @author Lê Công Nam .
 */

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> transitionList = new ArrayList<>();

    /**
     *  .
     * @param amount .
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.setBalance(this.getBalance() + amount);
        }
    }

    /**
     *  .
     * @param amount .
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.getBalance()) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    /**
     *  .
     * @param amount .
     * @param operation .
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            if (this.getBalance() % 10 != 0) {
                transitionList.add("Nap tien $"
                        + (double) Math.round(amount * 100) / 100
                        + ". So du luc nay: $"
                        + (double) Math.round(this.getBalance() * 100) / 100 + ".");
            } else {
                transitionList.add("Nap tien $"
                        + (double) Math.round(amount * 100) / 100 + "0"
                        + ". So du luc nay: $"
                        + (double) Math.round(this.getBalance() * 100) / 100 + "0" + ".");
            }
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            if (this.getBalance() % 10 != 0) {
                transitionList.add("Rut tien $"
                        + (double) Math.round(amount * 100) / 100 + "0"
                        + ". So du luc nay: $"
                        + (double) Math.round(this.getBalance() * 100) / 100 + ".");
            } else {
                transitionList.add("Rut tien $"
                        + (double) Math.round(amount * 100) / 100 + "0"
                        + ". So du luc nay: $"
                        + (double) Math.round(this.getBalance() * 100) / 100 + "0" + ".");
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     *  .
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i));
        }
    }

    /**
     *  .
     * @return .
     */
    public double getBalance() {
        return balance;
    }

    /**
     *  .
     * @param balance .
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
