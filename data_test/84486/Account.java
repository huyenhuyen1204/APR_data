import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList;

    /**
     * Constructor without parameter.
     */
    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }

    /**
     * Constructor with parameter.
     * @param balance balance.
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * get balance of this account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * set balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * do a transaction: deposit.
     * @param amount amount of money deposited.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * do a transaction: withdraw.
     * @param amount amount of money withdraw.
     */
    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            balance -= amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * add new transaction to transitionList.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print out transactions in transitionList.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        i + 1, transaction.getAmount(), transaction.getBalance());
            } else if (transaction.getOperation().equals(Transaction.WITHDRAW)) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        i + 1, transaction.getAmount(), transaction.getBalance());
            }
        }
    }
}
