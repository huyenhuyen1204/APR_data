import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList <Transaction> transaction;

    public Account () {
        this.balance = 0;
        transaction = new ArrayList<Transaction>();
    }

    private void deposit (double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw (double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else if (amount > this.balance) {
            System.out.println(" So tien ban rut vuot qua so du!");
        }
        else System.out.println("So tien ban rut ra khong hop le!");
    }

    public void addTransaction ( double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transaction.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transaction.add(new Transaction(operation, amount, this.balance));
        } else System.out.println("Yeu cau khong hop le!");
    }

    public double getRound(double x) {
        return (double) Math.round(x*100)/100 ;
    }

    public void printTransaction() {
        if (!transaction.isEmpty()) {
            for (int i = 0 ; i < transaction.size(); i++) {
                if (transaction.get(i).getOperation() == Transaction.DEPOSIT) {
                    System.out.println("Giao dich " + (i+1) + "Nap tien $" + transaction.get(i).getAmount() +
                            ".So du luc nay: $" + getRound(transaction.get(i).getBalance()) + ".");
                }
                else {
                    System.out.println("Giao dich " + (i+1) + "Rut tien $" + transaction.get(i).getAmount() +
                            ".So du luc nay: $" + getRound(transaction.get(i).getBalance()) + ".");
                }
            }
        }
    }



}
