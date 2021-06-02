import java.util.ArrayList;

public class Account {
    private Double balance;

    private ArrayList<Transaction> transactions;

    /**
     * cmt.
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * cmt.
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * cmt.
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * cmt.
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * cmt.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        balance += amount;
    }

    /**
     * cmt.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (balance <= amount) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * cmt.
     */
    public void printTransaction() {
        int size = transactions.size();
        for (int i = 0; i < size; i++) {
            Transaction trans = transactions.get(i);
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

    /**
     * cmt.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactions.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactions.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
}
