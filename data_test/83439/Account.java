import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
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
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            } else {
                withdraw(amount);
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            }
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich " + (i + 1) + ": Nap tien $" + "%.2f" + ". So du luc nay: $" + "%.2f" + ".\n",
                        transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                System.out.printf("Giao dich " + (i + 1) + ": Rut tien $" + "%.2f" + ". So du luc nay: $" + "%.2f" + ".\n",
                        transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            }
        }
    }
}
