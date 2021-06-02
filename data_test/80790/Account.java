import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance = this.balance - amount;
        }

    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) deposit(amount);
        else if (operation.equals(Transaction.WITHDRAW)) withdraw(amount);
        transactions.add(new Transaction(operation, amount, this.balance));
    }

    public void printTransaction() {
        int count = 0;
        for (Transaction transaction : transactions) {
            count++;
            transaction.setAmount(Math.round(transaction.getAmount() * 100) / 100.0);
            transaction.setBalance(Math.round(transaction.getBalance() * 100) / 100.0);
            if (transaction.getOperation().equals(transaction.WITHDRAW)) {
                System.out.print("Giao dich " + count + ": Rut tien $" + transaction.getAmount() + ". So du luc nay: $" + transaction.getBalance() + ".");
                System.out.println();
            }
            else if (transaction.getOperation().equals(transaction.DEPOSIT)) {
                System.out.print("Giao dich " + count + ": Nap tien $" + transaction.getAmount() + ". So du luc nay: $" + transaction.getBalance() + ".");
                System.out.println();
            }
        }
    }
}
