import java.util.ArrayList;

public class Account {
    private double balance = 0.00;
    private ArrayList<Transaction> transactions = new ArrayList<>();

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
     * withdraw return string.
     */
    private String withdraw() {
        return "WITHDRAW";
    }

    /**
     * Deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Withdraw.
     */
    public void withdraw(double amount) {
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
        Transaction transaction = new Transaction(operation, amount, balance);
        if (operation.equalsIgnoreCase(deposit())) {
            transactions.add(transaction);
        } else if (operation.equalsIgnoreCase(withdraw())) {
            transactions.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print TransactionList.
     */
    public void printTransaction() {
        String result = "";
        for (int i = 0; i < transactions.size(); i++) {
            int j = i + 1;
            double amt = (double) Math.round(transactions.get(i).getAmount() * 100) / 100;
            if (transactions.get(i).getOperation().equalsIgnoreCase(deposit())) {
                deposit(transactions.get(i).getAmount());
                result += "Giao dich " + j + ": Nap tien $"
                        + amt + ". So du luc nay: $"
                        + (double) Math.round(this.balance * 100) / 100 + "." + '\n';
            } else if (transactions.get(i).getOperation().equalsIgnoreCase(withdraw())) {
                withdraw(transactions.get(i).getAmount());
                result += "Giao dich " + j + ": Rut tien $"
                        + amt + ". So du luc nay: $"
                        + (double) Math.round(this.balance * 100) / 100 + "." + '\n';
            }


        }
        System.out.println(result);
    }

    /**
     * Main function.
     */
    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        System.out.println(acc.balance);
        acc.addTransaction(1000,"withdraw");
        System.out.println(acc.balance);
        //System.out.println(acc.transactions.size());
        acc.printTransaction();
    }
}

