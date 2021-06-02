import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<String> operationsList;
    static int id = 1;

    public Account() {
        this.balance = 0;
        operationsList = new ArrayList<>();
    }

    double round2Digit(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
                String s = "Giao dich " + id++ + ": Nap tien $" + round2Digit(amount) + ". So du luc nay: $" + round2Digit(balance) + ".";
                operationsList.add(s);
            } else {
                withdraw(amount);
                String s = "Giao dich " + id++ + ": Rut tien $" + round2Digit(amount) + ". So du luc nay: $" + round2Digit(balance) + ".";
                operationsList.add(s);
            }
        }
    }

    public void printTransaction() {
        for (String s : operationsList) {
            System.out.println(s);
        }
    }
}
