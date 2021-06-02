import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;

        private List<Transaction> transitionList;

    public Account() {
        balance = 0;
        transitionList = new ArrayList<Transaction>();
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            }
            else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        }
        else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    public void addTransaction(double amount, String operation) {
        switch (operation) {
            case Transaction.DEPOSIT:
                deposit(amount);
                transitionList.add(new Transaction(operation, amount, balance));
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                transitionList.add(new Transaction(operation, amount, balance));
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); ++i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Giao dich ");
            stringBuilder.append(i + 1);
            stringBuilder.append(": ");
            stringBuilder.append(transitionList.get(i).getOperation() == Transaction.DEPOSIT ? "Nap tien" : "Rut tien");
            stringBuilder.append(" $");
            stringBuilder.append(String.format("%.2f", transitionList.get(i).getAmount()));
            stringBuilder.append(". So du luc nay: $");
            stringBuilder.append(String.format("%.2f", transitionList.get(i).getBalance()));
            stringBuilder.append(".");
            System.out.println(stringBuilder);
        }
    }
    public static void main(String[] args) {
        Account account = new Account();
        account.addTransaction(2000.255, "deposit");
        account.addTransaction(1000, "withdraw");
        account.printTransaction();
    }
}
