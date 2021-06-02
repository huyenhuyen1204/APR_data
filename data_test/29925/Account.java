import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transitionList;
    int id = 1;

    public Account() {
        this.balance = 0;
        transitionList = new ArrayList<>();
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
                Transaction transaction = new Transaction(operation, amount, this.balance);
//                String s = "Giao dich " + id++ + ": Nap tien $" + round2Digit(amount) + ". So du luc nay: $" + round2Digit(balance) + ".";
//                transaction.setOperation(s);
                transitionList.add(transaction);
            } else {
                withdraw(amount);
                Transaction transaction = new Transaction(operation, amount, this.balance);
//                String s = "Giao dich " + id++ + ": Rut tien $" + round2Digit(amount) + ". So du luc nay: $" + round2Digit(balance) + ".";
//                transaction.setOperation(s);
                transitionList.add(transaction);
            }
        }
    }

    public void printTransaction() {
        for (Transaction s : transitionList) {
            if (s.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", id++, s.getAmount(), s.getBalance());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", id++, s.getAmount(), s.getBalance());
            }
        }
    }
}
