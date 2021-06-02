import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account() {

    }

    /**
     * Comment.
     **/
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }

    /**
     * Comment.
     **/
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }

    /**
     * Comment.
     **/
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if ((operation.equals(Transaction.WITHDRAW))) {
            withdraw(amount);
        }
    }

    /**
     * Comment.
     **/
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction a = transitionList.get(i);
            if (a.getOperation() == Transaction.DEPOSIT) {
                System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",
                        i + 1, "Nap tien", a.getAmount(), a.getBalance());
            } else {
                System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",
                        i + 1, "Rut tien", a.getAmount(), a.getBalance());
            }
        }
    }
}
