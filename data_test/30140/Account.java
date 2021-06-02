import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;
    public static DecimalFormat df = new DecimalFormat("####.##");

    public Account () {
        transitionList = new ArrayList<>();
        balance = 0;
    }

    private void deposit (double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transitionList.add(new Transaction("Nap tien", amount, balance));
        }
    }
    private void withdraw (double amount) {
        if(amount < 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transitionList.add(new Transaction("Rut tien", amount, balance));
        }
    }

    public void addTransaction (double amount, String operation) {
        operation = operation.toUpperCase();
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }
    public void printTransaction () {
        int i = 1;
        for (Transaction tr : transitionList) {
            String amount = df.format(tr.getAmount());
            String balance = df.format(tr.getBalance());
            if (!amount.contains(".")) {
               amount+=".00";
            }
            if (!balance.contains(".")) {
                balance+=".00";
            }
            System.out.println("Giao dich "+i+": "+tr.getOperation()+" $"+amount+". So du luc nay: $"+balance+".");
            i++;
        }
    }

    public static void main (String [] args) {
        Account acc = new Account();
        acc.addTransaction(2000, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
