import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> trs = new ArrayList<>();

    public Account() {
        balance = 0;
    }

    public static String fixed(double db) {
        return String.format("%.2f", db);
    }

    /**
     * deposit money into this account.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        Transaction tr = new Transaction(Transaction.DEPOSIT, amount, balance);
        trs.add(tr);
    }

    /**
     * withdraw $amount from this account.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance -= amount;
            Transaction tr = new Transaction(Transaction.WITHDRAW, amount, balance);
            trs.add(tr);
        }
    }

    /**
     * add transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * print log.
     */
    public void printTransaction() {
        String rt = "";
        for (int i = 0; i < trs.size(); ++i) {
            rt += "Giao dich " + (i + 1) + ": ";
            if (trs.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                rt += "Nap tien $" + fixed(trs.get(i).getAmount());
            } else if (trs.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                rt += "Rut tien $" + fixed(trs.get(i).getAmount());
            }

            rt += ". So du luc nay: $" + fixed(trs.get(i).getBalance());

            if (i != trs.size() - 1) {
                rt += ".\n";
            }
        }

        System.out.println(rt);
    }
}
