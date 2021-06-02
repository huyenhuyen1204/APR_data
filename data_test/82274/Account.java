import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(transaction);
            return;
        }
        System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            transitionList.add(transaction);
        }
    }

    /**
     * .
     **/
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * .
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.print("Giao dich " + (i + 1) + ": Nap tien $");
                System.out.printf("%.2f", transitionList.get(i).getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transitionList.get(i).getBalance());
                System.out.print(".");
                System.out.println();
            } else {
                System.out.print("Giao dich " + (i + 1) + ": Rut tien $");
                System.out.printf("%.2f", transitionList.get(i).getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transitionList.get(i).getBalance());
                System.out.print(".");
                System.out.println();
            }
        }
    }
}
