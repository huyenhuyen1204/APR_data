import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transactionArrayList = new ArrayList<>();

    /**
     * Diposit function.
     * @param amount money
     */
    private void diposit(double amount) {

        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        balance += amount;

    }

    /**
     * Withdraw function.
     * @param amount money
     */
    private void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        balance -= amount;

    }

    /**
     * Add new transaction.
     * @param amount money
     * @param operation transaction type
     */
    public void addTransaction(double amount, String operation) {

        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }

        if (operation.equals(Transaction.DEPOSIT)) {
            diposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        }

        transactionArrayList.add(new Transaction(operation, amount, this.balance));

    }

    /**
     * Print transaction list.
     */
    public void printTransaction() {

        for (int i = 0; i < transactionArrayList.size(); i++) {
            Transaction transaction = transactionArrayList.get(i);
            String operation = (transaction.equals(Transaction.WITHDRAW))
                    ? "Rut tien" : "Nap tien";
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n", i + 1, operation,
                    transaction.getAmount(), transaction.getBalance());
        }

    }

}
