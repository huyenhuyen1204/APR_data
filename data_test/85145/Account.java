import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList;

    public Account() {
        transactionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else if (amount <= 0){
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!(operation.compareTo(Transaction.DEPOSIT) == 0 ||
                operation.compareTo(Transaction.WITHDRAW) == 0)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == Transaction.WITHDRAW) {
                withdraw(amount);
            } else {
                deposit(amount);
            }
            transactionList.add(new Transaction(operation, amount, balance));
        }
    }

    public void printTransaction() {
        if (transactionList == null) {
            return;
        }
        int time = 1;
        for (Transaction i : transactionList) {
            String s = "";
            if (i.getOperation() == Transaction.DEPOSIT) {
                s = "Nap tien";
            } else {
                s = "Rut tien";
            }
            System.out.println(String.format("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.",
                    time++, s, i.getAmount(), i.getBalance()));
        }
    }
}
