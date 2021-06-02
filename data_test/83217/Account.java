import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();


    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
    }

    /**
     * alo12344433.
     */

    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            return;
        }
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            return;
        }
    }

    /**
     * heyyyyy.
     */
    public void printTransaction() {
        for (int i = 0; i < this.transitionList.size(); i++) {
            if (this.transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                String a = String.format("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.",
                        i + 1, this.transitionList.get(i).getAmount(),
                        this.transitionList.get(i).getBalance());
                System.out.println(a);
            } else {
                String a = String.format("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.",
                        i + 1, this.transitionList.get(i).getAmount(),
                        this.transitionList.get(i).getBalance());
                System.out.println(a);
            }
        }
    }


}
