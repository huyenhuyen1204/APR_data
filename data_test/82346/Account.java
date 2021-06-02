import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * comment.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("gui")) {
            this.deposit(amount);
            Transaction Tien = new Transaction(operation, amount, this.balance);
            transitionList.add(Tien);
        } else if (operation.equals("rut")) {
            this.withdraw(amount);
            Transaction Tien = new Transaction(operation, amount, this.balance);
            transitionList.add(Tien);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * getInfo.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich" + (i + 1) + ": " + transitionList.get(i).toString());
        }
    }
}
