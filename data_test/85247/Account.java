import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    /**
     * deposit.
     * @param amount .
     */

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * withdraw.
     * @param amount .
     */

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * add method.
     * @param amount .
     * @param operation .
     */

    public void addTransaction(double amount, String operation) {
        Transaction t;
        switch (operation) {
            case Transaction.DEPOSIT:
                this.deposit(amount);
                t = new Transaction(operation, amount, balance);
                transactionList.add(t);
                break;
            case Transaction.WITHDRAW:
                this.withdraw(amount);
                t = new Transaction(operation, amount, balance);
                transactionList.add(t);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }

    /**
     * print method.
     */

    public void printTransaction() {
        for (Transaction t : transactionList) {
            System.out.print("Giao dich " + (transactionList.indexOf(t) + 1) + ": ");
            switch (t.getOperation()) {
                case Transaction.DEPOSIT:
                    System.out.println("Nap tien $" + String.format("%.2f", t.getAmount())
                            + ". So du luc nay: $" + String.format("%.2f", t.getBalance()) + ".");
                    break;
                case Transaction.WITHDRAW:
                    System.out.println("Rut tien $" + String.format("%.2f", t.getAmount())
                            + ". So du luc nay: $" + String.format("%.2f", t.getBalance()) + ".");
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Main test.
     * @param args .
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
