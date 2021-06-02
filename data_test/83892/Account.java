import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transactions;

    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    /**
     * nap.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien nap vao khong hop le!");
        }
    }

    /**
     * rut.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount <= this.balance && amount > 0) {
            balance -= amount;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * them giao dich.
     */
    public void addTransaction(double amount , String operation) {
        if (!operation.equals(Transaction.WITHDRAW) && !operation.equals(Transaction.DEPOSIT)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation.equals(Transaction.DEPOSIT)) {
            this.deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            this.withdraw(amount);
        }

        Transaction transaction = new Transaction(operation, amount, this.balance);
        this.transactions.add(transaction);
    }

    /**
     * print.
     */
    public void printTransaction() {
        for (Transaction tran : transactions) {
            double countAmo = Math.ceil(tran.getAmount() * 100) / 100;
            double countBala = Math.ceil(tran.getBalance() * 100) / 100;
            String operation = null;
            if (tran.getOperation(). equals(Transaction.DEPOSIT)) {
                operation = "Nap tien $";
            } else if (tran.getOperation(). equals(Transaction.WITHDRAW)) {
                operation = "Rut tien $";
            }

            System.out.println(operation + countAmo + ". So du luc nay: $" + countBala);
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }


}
