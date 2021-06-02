import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    public List<Transaction> transactions = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction depositTran = new Transaction(Transaction.DEPOSIT, amount, balance);
            transactions.add(depositTran);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du");
            } else {
                balance -= amount;
                Transaction withdrawTran = new Transaction(Transaction.WITHDRAW, amount, balance);
                transactions.add(withdrawTran);
            }
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == Transaction.DEPOSIT) {
                deposit(amount);
            }
            if (operation == Transaction.WITHDRAW) {
                withdraw(amount);
            }
        }
    }

    public void printTransaction() {
        int j = 0;
        for (Transaction i : transactions) {
            String s = null;
            if (i.getOperation().equals(Transaction.DEPOSIT)) {
                s = String.format("Giao dich %s: Nap tien $%.5g. So du luc nay: $%.5g.", j, i.getAmount(), i.getBalance());
            }
            if (i.getOperation().equals(Transaction.WITHDRAW)) {
                s = String.format("Giao dich %s: Rut tien $%.5g. So du luc nay: $%.5g.", j, i.getAmount(), i.getBalance());
            }
            System.out.println(s);
            j++;
        }
    }
}
