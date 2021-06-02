import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * cmt.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * cmt.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * cmt.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * cmt.
     */
    public ArrayList<Transaction> getTransitionList() {
        return transitionList;
    }

    /**
     * cmt.
     */
    public void setTransitionList(ArrayList<Transaction> transitionList) {
        this.transitionList = transitionList;
    }

    /**
     * cmt.
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
     * cmt.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * cmt.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction trans = transitionList.get(i);
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (trans.getOperation().equalsIgnoreCase(Transaction.DEPOSIT)) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }
            System.out.format("%.2f", trans.getAmount());
            System.out.print(String.format(". So du luc nay: $%.2f",
                    trans.getBalance()) + ".\n");
        }
    }
}
