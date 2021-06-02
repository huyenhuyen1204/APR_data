import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;

    private List<Transaction> transactionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du");
        }
    }

    public void addTransaction(double amount, String operation) {
        if(operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            if (amount > 0) {
                balance = balance + amount;
                Transaction transaction = new Transaction(operation, amount, balance);
                transactionList.add(transaction);
            }

        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            if (amount <= balance) {
                balance = balance - amount;
                Transaction transaction = new Transaction(operation, amount, balance);
                transactionList.add(transaction);
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            String res = "";
            res = res + transactionList.get(i).getOperation();
            if (res.equals(Transaction.DEPOSIT)) {
                System.out.print("Giao dich " + (i + 1) + ": Nap tien $"
                        + (Math.floor(transactionList.get(i).getAmount() * 10) / 10)
                        + ". So du luc nay: $" + (Math.floor(transactionList.get(i).getBalance() * 10) / 10) + ".");
            } else if (res.equals(Transaction.WITHDRAW)) {
                System.out.print("Giao dich " + (i + 1) + ": Rut tien $"
                        + (Math.floor(transactionList.get(i).getAmount() * 10) / 10)
                        + ". So du luc nay: $" + (Math.floor(transactionList.get(i).getBalance() * 10) / 10) + ".");
            }
        }
    }
}
