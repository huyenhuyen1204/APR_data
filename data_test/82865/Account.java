import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    List<Transaction> transactionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount >= 0) {
            this.balance = this.balance + amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!\n");
        }
    }

    private void withdraw(double amount) {
        if (amount >= 0) {
            if (amount <= this.balance) {
                this.balance = this.balance - amount;
            } else {
                System.out.println("So tien ban rut vuot qua so du!\n");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!\n");
        }
    }

    /**
     * giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!\n");
        } else {
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                this.withdraw(amount);
            }
        }
        Transaction transaction = new Transaction(operation, amount, this.balance);
        transactionList.add(transaction);
    }

    /**
     * in giao dich.
     */

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            int t = i + 1;
            double tienGiaodich = (double) Math.round(transactionList.get(i).getAmount() * 100) / 100;
            double tienDu = (double) Math.round(transactionList.get(i).getBalance() * 100) / 100;
            if (transactionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + t + ": Nap tien $"
                                                + tienGiaodich + ". So du luc nay: $" + tienDu + "." );
            } else {
                System.out.println("Giao dich " + t + ": Rut tien $"
                                                + tienGiaodich + ". So du luc nay: $" + tienDu + "." );
            }
        }
    }

    /**
     * main.
     */

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
