
import java.util.ArrayList;

public class Account {
    private double balance = 0.0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction newTransaction = new Transaction("deposit", amount, balance);
            transitionList.add(newTransaction);
        }
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
            Transaction newTransaction = new Transaction("withdraw", amount, balance);
            transitionList.add(newTransaction);
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println(" Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < transitionList.size(); ++i) {
            String amountString = String.format("%.02f", transitionList.get(i).getAmount());
            String balanceString = String.format("%.02f", transitionList.get(i).getBalance());
            int pos = i + 1;
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                balance += transitionList.get(i).getAmount();
                res.append("Giao dich ").append(pos).append(": ")
                        .append("Nap tien $").append(amountString)
                        .append(". ").append("So du luc nay: $")
                        .append(balanceString).append(".\n");
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                balance -= transitionList.get(i).getAmount();
                res.append("Giao dich ").append(pos).append(": ")
                        .append("Rut tien $").append(amountString)
                        .append(". ").append("So du luc nay: $")
                        .append(balanceString).append(".\n");
            }
        }
        System.out.println(res);
    }
}
