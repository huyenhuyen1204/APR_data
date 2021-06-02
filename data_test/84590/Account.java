import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transactionList.add(transaction);
            if (operation == Transaction.DEPOSIT) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            String s = "Giao dich " + i + 1 + " ";
            if (transactionList.get(i).getOperation() == Transaction.DEPOSIT) {
                s += "Nap tien ";
            } else {
                s += "Rut tien ";
            }
            s += transactionList.get(i).getAmount() + ". So du luc nay: "
                    + transactionList.get(i).getBalance() + ".";
            System.out.println(s);
        }
    }
}
