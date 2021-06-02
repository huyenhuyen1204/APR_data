import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        Transaction t;
        switch (operation) {
            case Transaction.DEPOSIT:
                this.deposit(amount);
                t = new Transaction(operation, amount, balance);
                transactions.add(t);
                break;
            case Transaction.WITHDRAW:
                this.withdraw(amount);
                t = new Transaction(operation, amount, balance);
                transactions.add(t);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }

    public void printTransaction() {
        for(Transaction t : transactions) {
            System.out.print("Giao dich " + transactions.indexOf(t) + ": ");
            switch (t.getOperation()) {
                case Transaction.DEPOSIT:
                    System.out.println("Nap tien $" + Math.round(100*t.getAmount()) / 100.00
                            + ". So du luc nay: $" + Math.round(100*t.getBalance()) / 100.00 + ".");
                    break;
                case Transaction.WITHDRAW:
                    System.out.println("Rut tien $" + Math.round(100*t.getAmount()) / 100.00
                            + ". So du luc nay: $" + Math.round(100*t.getBalance()) / 100.00 + ".");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
