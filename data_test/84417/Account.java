import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

    /**
     * a.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * a.
     */
    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
        }
    }

    /**
     * a.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.deposit)) {
            deposit(amount);
            transactionList.add(new Transaction(Transaction.deposit, amount, balance));
        } else if (operation.equals(Transaction.withdraw)) {
            withdraw(amount);
            transactionList.add(new Transaction(Transaction.withdraw, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * a.
     */
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); ++i) {
            Transaction transaction = transactionList.get(i);
            String s = "Giao dich " + (i + 1);
            if (transaction.getOperation().equals(Transaction.deposit)) {
                s += ": Nap tien $";
            } else {
                s += ": Rut tien $";
            }
            s += String.format("%.2f. So du luc nay: $%.2f.", transaction.getAmount(), transaction.getBalance());
            System.out.println(s);
        }
    }
    /*public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }*/
}