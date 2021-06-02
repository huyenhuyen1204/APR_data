import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Nap tien.
     * param amount
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            setBalance(getBalance() + amount);
        }
    }

    /**
     * Rut tien.
     * param amount
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    /**
     * Them giao dich.
     * param amount
     * param operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            if (amount > 0) {
                deposit(amount);
                Transaction tran = new Transaction("Nap tien",
                        (double) Math.round(amount * 100) / 100,
                        (double) Math.round(getBalance() * 100) / 100);
                transitionList.add(tran);
            } else {
                deposit(amount);
            }
        } else if (operation.equals(Transaction.WITHDRAW)) {
            if (amount > 0 && amount < getBalance()) {
                withdraw(amount);
                Transaction tran1 = new Transaction("Rut tien",
                        (double) Math.round(amount * 100) / 100,
                        (double) Math.round(getBalance() * 100) / 100);
                transitionList.add(tran1);
            } else if (amount < 0) {
                withdraw(amount);
            } else if (amount > getBalance()) {
                withdraw(amount);
            }
        } else if (operation.equals(Transaction.DEPOSIT) == false
                    || operation.equals(Transaction.WITHDRAW) == false) {
                System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * In ra cac giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich " + (i + 1) + ": "
                    + transitionList.get(i).getOperation()
                    + " $" + String.format("%.2f", transitionList.get(i).getAmount())
                    + ". " + "So du luc nay: "
                    + "$" + String.format("%.2f", transitionList.get(i).getBalance()) + ".");
        }
    }
}
