import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList;
    private double[] balances = new double[100];
    private int i = 0;

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
        //Transaction transaction = new Transaction(operation, amount, this.balance);
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            if (amount > 0)
                balances[i++] = this.balance;
                transactionList.add(new Transaction(operation, amount, this.balance));
        }
        else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            if (amount > 0 && amount <= this.balance)
                balances[i++] = this.balance;
                transactionList.add(new Transaction(operation, amount, this.balance));
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
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + getRound(transactionList.get(i).getAmount()) + ". So du luc nay: $" + getRound(balances[i]) + ".");
            else
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + getRound(transactionList.get(i).getAmount()) + ". So du luc nay: $" + getRound(balances[i]) + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
