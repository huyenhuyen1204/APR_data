import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> historyTransactions;

    public Account(double balance) {
        this.balance = balance;
        this.historyTransactions = new ArrayList<>();
    }

    public Account() {
        this.balance = 0;
        this.historyTransactions = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        this.balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            this.deposit(amount);
            Transaction tran = new Transaction(operation, amount, this.balance);
            this.historyTransactions.add(tran);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            this.withdraw(amount);
            Transaction tran = new Transaction(operation, amount, this.balance);
            this.historyTransactions.add(tran);
        }
    }

    public void printTransaction() {
        for (int i = 0; i < this.historyTransactions.size(); i++) {
            Transaction t = this.historyTransactions.get(i);
            String mess = "Giao dich " + (i + 1);
            if (t.getOperation().equals(Transaction.DEPOSIT)) {
                mess += ": Nap tien ";
            } else {
                mess += ": Rut tien ";
            }
            mess += "$" + String.format("%.2f", t.getAmount())
                    + ". So du luc nay: $" + String.format("%.2f", t.getBalance()) + ".";

            System.out.println(mess);
        }
    }


    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
