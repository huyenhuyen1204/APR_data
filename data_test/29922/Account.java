import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {

    }

    public void deposit(double amount) {
        if(amount > 0)
            this.balance += amount;
        else System.out.println("So tien ban nap vao khong hop le!");
    }

    public void withdraw(double amount) {
        if(amount > this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else if(amount > 0) {
            this.balance -= amount;
        } else
            System.out.println("So tien ban rut ra khong hop le!");
    }

    public void addTransaction(double amount, String operation) {
        if(operation == "deposit") {
            deposit(amount);
            transactions.add(new Transaction(operation, amount, this.balance));
        } else
        if(operation == "withdraw") {
            withdraw(amount);
            transactions.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
    public void  printTransaction() {
        int i = 1;
        for (Transaction transaction : transactions) {
            System.out.print("Giao dich " + i + ": ");
            if (transaction.getOperation() == transaction.DEPOSIT) {
                System.out.print("Nap tien $");
                System.out.printf("%.2f", transaction.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transaction.getBalance());
                System.out.println(".");
            } else {
                System.out.print("Rut tien $");
                System.out.printf("%.2f", transaction.getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transaction.getBalance());
                System.out.println(".");
            }
            ++i;
        }
    }
}
