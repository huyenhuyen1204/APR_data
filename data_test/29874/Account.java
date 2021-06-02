import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
            this.transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }
    private void withdraw(double amount) {
        if(amount > 0) {
            if(amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                this.balance -= amount;
                this.transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }

    }

    public void addTransaction(double amount, String operation) {
        if(operation == Transaction.DEPOSIT) {
            deposit(amount);
        } else if(operation == Transaction.WITHDRAW) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        int i = 1;
        for (Transaction t: transitionList) {
            if(t.getOperation() == Transaction.DEPOSIT) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", i, t.getAmount(), t.getBalance());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", i, t.getAmount(), t.getBalance());
            }
            i++;
        }
    }
    
}
