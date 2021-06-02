
import java.util.ArrayList;

public class Account {
    private double balance = 0.0;
    private ArrayList<Transaction> transitionHistory = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction newTransaction = new Transaction("DEPOSIT", amount, balance);
            transitionHistory.add(newTransaction);
        }
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
            Transaction newTransaction = new Transaction("WITHDRAW", amount, balance);
            transitionHistory.add(newTransaction);
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
        for (int i = 0; i < transitionHistory.size(); ++i) {
            String formattedString1 = String.format("%.02f", transitionHistory.get(i).getAmount());
            String formattedString2 = String.format("%.02f", transitionHistory.get(i).getBalance());
            int pos = i + 1;
            if (transitionHistory.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                balance += transitionHistory.get(i).getAmount();
                res.append(res).append("Giao dich ").append(pos).append(": ")
                        .append("Nap tien $").append(formattedString1)
                        .append(". ").append("So du luc nay: $")
                        .append(formattedString2).append(".\n");
            } else if (transitionHistory.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                balance -= transitionHistory.get(i).getAmount();
                res.append("Giao dich ").append(pos).append(": ")
                        .append("Rut tien $").append(formattedString1)
                        .append(". ").append("So du luc nay: $")
                        .append(formattedString2).append(".\n");
            }
        }
        System.out.println(res);
    }
}
