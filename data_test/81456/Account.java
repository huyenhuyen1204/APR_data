import java.util.ArrayList;

public class Account {
    private double inforBalance;
    private ArrayList<Transaction> history = new ArrayList<>();
    private String deposit;
    private String withdraw;
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap khong hop le!");
        } else {
            inforBalance += amount;
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut khong hop le!");
        } else if (amount < inforBalance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            inforBalance -= amount;
        }
    }
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("DEPOSIT") && !operation.equals("WITHDRAW")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            boolean check = false;
            if (operation.equals("DEPOSIT")) {
                double balance = inforBalance;
                deposit(amount);
                if (inforBalance == balance - amount) {
                    check = true;
                }
            }
            if (operation.equals("WITHDRAW")) {
                double balance = inforBalance;
                withdraw(amount);
                if (inforBalance == balance - amount) {
                    check = true;
                }
            }
            if (check) {
                Transaction transaction = new Transaction(operation, amount, inforBalance);
                history.add(transaction);
            }
        }
    }
    public void printTransaction() {
        for (int i = 1; i <= history.size(); i++) {
            System.out.println("Giao dich " + i + ": ");
            if (history.get(i).getOperation().equals("DEPOSIT")) {
                System.out.println("Nap tien $");
            }
            if (history.get(i).getOperation().equals("WITHDRAW")) {
                System.out.println("Rut tien $");
            }
            System.out.println("" + Math.round(history.get(i).getAmount()) + ". ");
            System.out.println("So du luc nay: $" + Math.round(history.get(i).getBalance()) + ".");
        }
    }
}
