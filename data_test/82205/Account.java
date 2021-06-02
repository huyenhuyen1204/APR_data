import java.text.DecimalFormat;
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
     * deposit return string.
     */
    private String deposit() {
        return "DEPOSIT";
    }

    /**
     * Deposit.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * withdraw return string.
     */
    private String withdraw() {
        return "WITHDRAW";
    }

    /**
     * Withdraw.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
             setBalance(balance - amount);
        }
    }

    /**
     * Add transaction.
     */
    public void addTransaction(double amount, String operation) {
        Transaction transaction = new Transaction(operation, amount, this.balance);
        if (operation.equalsIgnoreCase(deposit())) {
            transitionList.add(transaction);
            deposit(amount);
        } else if (operation.equalsIgnoreCase(withdraw())) {
            transitionList.add(transaction);
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print TransactionList.
     */
    public void printTransaction() {
        DecimalFormat f = new DecimalFormat("##.00");
        String result = "";
        this.balance = 0;
        for (int i = 0; i < transitionList.size(); i++) {
            int j = i + 1;
            if (transitionList.get(i).getOperation().equalsIgnoreCase(deposit())) {
                deposit(transitionList.get(i).getAmount());
                result += "Giao dich " + j + ": Nap tien $"
                        + f.format(transitionList.get(i).getAmount()) + ". So du luc nay: $"
                        + f.format(balance) + "." + '\n';
            } else if (transitionList.get(i).getOperation().equalsIgnoreCase(withdraw())) {
                withdraw(transitionList.get(i).getAmount());
                result += "Giao dich " + j + ": Rut tien $"
                        + f.format(transitionList.get(i).getAmount()) + ". So du luc nay: $"
                        + f.format(balance) + "." + '\n';
            }


        }
        System.out.println(result);
    }

    /**
     * Main function.
     */
    public static void main(String[] args) {
        
    }
}

