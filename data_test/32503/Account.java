import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList;

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban  nap vao khong hop le!");
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
        if (!(operation.equals("deposit") || operation.equals(Transaction.WITHDRAW))) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }

        if (operation.equals("deposit")) {
            deposit(amount);
            if (amount > 0)
                    transactionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
            return;
        }

        withdraw(amount);
        if ((amount > 0) && (amount <= balance))
            transactionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            double tempAmount = Math.round(transactionList.get(i).getAmount() * 100) / 100;
            double tempBalance = Math.round(transactionList.get(i).getBalance() * 100) / 100;
            System.out.println("Giao dich " + i + ": " + transactionList.get(i).getOperation()
            + " $" + tempAmount + ". " + "So du luc nay: $" + tempBalance + ".");
        }
    }
}
