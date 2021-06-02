import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Javadoc Comment.
     */
    public Account() {
        balance = 0.00;
    }

    /**
     * Javadoc Comment.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            amount = Double.valueOf(String.format("%.2f", amount));
            balance += amount;
            Transaction newTransaction =
                    new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(newTransaction);
        }
    }

    /**
     * Javadoc Comment.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            amount = Double.valueOf(String.format("%.2f", amount));
            balance -= amount;
            Transaction newTransaction =
                    new Transaction(Transaction.WITHDRAW, amount, balance);
            transitionList.add(newTransaction);
        }
    }

    /**
     * Javadoc Comment.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit")
                && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals("deposit")) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
        }
    }

    /**
     * Javadoc Comment.
     */
    public void printTransaction() {
        Transaction current;
        String operation;
        String amount;
        String balance;
        for (int i = 0; i < transitionList.size(); i++) {
            current = transitionList.get(i);
            if (current.getOperation().equals(Transaction.DEPOSIT)) {
                operation = "Nap tien $";
            } else {
                operation = "Rut tien $";
            }
            if ((current.getAmount() * 100) % 10 == 0) {
                amount = current.getAmount() + "0";
            } else {
                amount = String.valueOf(current.getAmount());
            }
            if ((current.getBalance() * 100) % 10 == 0) {
                balance = current.getBalance() + "0";
            } else {
                balance = String.valueOf(current.getBalance());
            }
            System.out.println("Giao dich " + (i + 1) + ": " + operation + amount
                    + ". So du luc nay: $" + balance + ".");
        }
    }
}
