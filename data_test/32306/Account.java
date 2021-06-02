import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transactionList;

    public Account() {
        transactionList = new ArrayList<>();
        this.balance = 0;
    }

    private void deposit(double amount) {
        if (amount > 0)
            balance+= amount;
        else
            System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance)
                System.out.println("So tien ban rut vuot qua so du!");
            else
                balance-= amount;
        }
        else
            System.out.println("So tien ban rut ra khong hop le!");
    }

    public void addTransaction(double amount, String operation) {
        Transaction transaction = new Transaction(operation, amount, this.balance);
        if (operation.equals(transaction.DEPOSIT)) {
            deposit(amount);
            if (amount > 0)
                transactionList.add(transaction);
        }
        else if (operation.equals(transaction.WITHDRAW)) {
            withdraw(amount);
            if (amount > 0 && amount <= this.balance)
                transactionList.add(transaction);
        }
        else
            System.out.println("Yeu cau khong hop le!");
    }

    public String getRound(double x) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(x);
    }

    public void printTransaction() {
        for (int i = 0; i<transactionList.size(); i++) {
            if (transactionList.get(i).getOperation().equals("deposit"))
                System.out.println("Giao dich " + i + ": Nap tien $" + getRound(transactionList.get(i).getAmount()) + ". So du luc nay: $" + getRound(this.balance) + ".");
            else
                System.out.println("Giao dich " + i + ": Rut tien $" + getRound(transactionList.get(i).getAmount()) + ". So du luc nay: $" + getRound(this.balance) + ".");
        }
    }


}
