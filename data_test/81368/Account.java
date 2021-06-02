import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * deposit.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * withdraw.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * addTransaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, balance);
            transactions.add(transaction);
        }
    }

    /**
     * printTransaction.
     */
    public void printTransaction() {
        int n = transactions.size();
        for (int i = 0; i < n; i++) {
            String output = "Giao dich " + (i + 1) + ": ";
            Transaction transaction = transactions.get(i);
            double amount = (double) Math.round(transaction.getAmount() * 100) / 100;
            double balance_= (double) Math.round(transaction.getBalance() * 100) / 100;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                output += "Nap tien $" + decimalFormat.format(amount) + ". So du luc nay: $" + decimalFormat.format(balance_) + ".";
            }
            if (transaction.getOperation().equals(Transaction.WITHDRAW)) {
                output += "Rut tien $" + decimalFormat.format(amount) + ". So du luc nay: $" + decimalFormat.format(balance_) + ".";
            }
            System.out.println(output);
        }
    }

    /**
     * getBalance.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setBalance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * getTransactions.
     * @return Arraylist
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * setTransaction.
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    /*
    public static void main(String[] args) {
        Account account = new Account();
        account.addTransaction(2000.255, "deposit");
        account.addTransaction(1000, "withdraw");
        account.printTransaction();
    }*/
}
