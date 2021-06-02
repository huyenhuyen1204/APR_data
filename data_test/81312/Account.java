import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * deposit operation.
     * @param amount amount of operation.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * withdraw operation.
     * @param amount amount of operation.
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > this.balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                this.balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    /**
     * add a transaction to field transactionList.
     * @param amount amount of operation.
     * @param operation type operation.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            this.deposit(amount);
            Transaction transaction =
                    new Transaction(Transaction.DEPOSIT, amount, this.balance);
            this.transactionList.add(transaction);

        } else if (operation.equals(Transaction.WITHDRAW)){
            this.withdraw(amount);
            Transaction transaction =
                    new Transaction(Transaction.WITHDRAW, amount, this.balance);
            this.transactionList.add(transaction);

        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }

    /**
     * print information of transaction in transactionList.
     */
    public void printTransaction() {
        for (int i = 0; i < this.transactionList.size(); i++) {
            Transaction tran = this.transactionList.get(i);
            String operation = tran.getOperation();
            String operationVie;

            if (operation.equals(Transaction.DEPOSIT)) {
                operationVie = "Nap tien";
            } else {
                operationVie = "Rut tien";
            }
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",
                    i + 1, operationVie, tran.getAmount(), tran.getBalance());
        }

    }

}
