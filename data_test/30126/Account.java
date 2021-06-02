import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transitionList;
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
            System.out.println("so tien ban rut khong hop le!");
        else if (amount > balance) {
            System.out.println("so tien ban rut vuot qua so du!");
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
            System.out.println("yeu cau khong hop le");
        }

    }
    public void printTransaction () {
        int i = 1;
        for (Transaction tr : transitionList) {
            System.out.println("Giao dich "+i+": "+tr.getOperation()+" $"+df.format(tr.getAmount())+". So du luc nay: $"+df.format(tr.getBalance())+".");
            i++;
        }
    }

    public static void main (String [] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
