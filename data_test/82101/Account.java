import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equalsIgnoreCase(Transaction.DEPOSIT) && !operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        Transaction transaction = new Transaction(operation, amount, balance);
        transactionList.add(transaction);
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.print("Giao dich " + i + 1 + ": ");
            if (transactionList.get(i).getOperation().equalsIgnoreCase(Transaction.DEPOSIT)) {
                System.out.print("Nap tien ");
            } else {
                System.out.print("Rut tien ");
            }

            System.out.print("$" + Math.round(transactionList.get(i).getAmount() * 100) / 100 + ".");
            System.out.print(" So du luc nay: $" + Math.round(transactionList.get(i).getBalance() * 100) / 100);
            System.out.print(".\n");
        }
    }
}
