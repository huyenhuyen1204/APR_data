/**
 * @author Lê Công Nam
 */

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> listOperation = new ArrayList<>();

    /**
     *  .
     * @param amount .
     */
    public void deposit(double amount) {
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
    public void withdraw(double amount) {
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
            listOperation.add("Nap tien $"
                    +(double) Math.round(amount * 100) / 100
                    + ". So du luc nay: $"
                    +(double) Math.round(this.getBalance() * 100) / 100 + ".");
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            listOperation.add("Rut tien $"
                    +(double) Math.round(amount * 100) / 100
                    + ". So du luc nay: $"
                    +(double) Math.round(this.getBalance() * 100) / 100 + ".");
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     *  .
     */
    public void printTransaction() {
        for (int i = 0; i < listOperation.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + listOperation.get(i));
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

    /**
     *  .
     * @return .
     */
    public ArrayList getListOperation() {
        return listOperation;
    }

    /**
     *  .
     * @param listOperation .
     */
    public void setListOperation(ArrayList listOperation) {
        this.listOperation = listOperation;
    }
}
