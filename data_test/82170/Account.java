import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

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

    /**
     * ...
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactionList.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactionList.add(new Transaction(operation, amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * ...
     */
    public void printTransaction() {
        String deposit = "Nap tien";
        String withdraw = "Rut tien";
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.printf("Giao dich %s: %s $%.2f. So du luc nay: $%.2f.\n", i + 1,
                    (transactionList.get(i).getOperation().equals(Transaction.DEPOSIT) ?
                            deposit : withdraw),
                    transactionList.get(i).getAmount(),
                    transactionList.get(i).getBalance());
        }
    }


}
