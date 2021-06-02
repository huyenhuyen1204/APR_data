import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private List<String> transactionHistory = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#.00");

    private void deposit(double amount) {
        String amountStr = df.format(amount);
        amount = Double.parseDouble(amountStr);

        if (amount > 0) {
            setBalance(getBalance() + amount);
            String balanceStr = df.format(balance);
            transactionHistory.add("Giao dich " + (transactionHistory.size() + 1)
                    + ": Nap tien $" + amountStr
                    + ". So du luc nay: $" + balanceStr + ".");
        } else {
            transactionHistory.clear();
            transactionHistory.add("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        String amountStr = df.format(amount);
        amount = Double.parseDouble(amountStr);

        if (amount > balance) {
            transactionHistory.clear();
            transactionHistory.add("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            setBalance(getBalance() - amount);
            String balanceStr = df.format(balance);
            transactionHistory.add("Giao dich " + (transactionHistory.size() + 1)
                    + ": Rut tien $" + amountStr + ". So du luc nay: $" + balanceStr + ".");
        } else {
            transactionHistory.clear();
            transactionHistory.add("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Add new transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            transactionHistory.clear();
            transactionHistory.add("Yeu cau khong hop le!");
        } else {
            Transaction newTransaction = new Transaction(operation, amount, balance);
            transitionList.add(newTransaction);
            if (Objects.equals(operation, "deposit")) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
        }
    }

    /**
     * print transactions.
     */
    public void printTransaction() {
        for (String s : transactionHistory) {
            System.out.println(s);
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
