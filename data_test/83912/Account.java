import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }

    /**
     * nap.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
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
        this.transitionList.add(transaction);
    }

    /**
     * print.
     */
    public void printTransaction() {
        int count = 1;
        for (Transaction tran : transitionList) {
            double countAmo = (double)(Math.ceil(tran.getAmount() * 1000) / 1000);

            double countBala = (double)(Math.ceil(tran.getBalance() * 1000) / 1000);
            String operation = null;
            if (tran.getOperation(). equals(Transaction.DEPOSIT)) {
                operation = ": Nap tien $";
            } else if (tran.getOperation(). equals(Transaction.WITHDRAW)) {
                operation = ": Rut tien $";
            }

            System.out.println( "Giao dich "+ count + operation + String.format("%.2f", countAmo)
                    + ". So du luc nay: $" + String.format("%.2f", countBala) + ".");
            count ++;
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();

    }

}
