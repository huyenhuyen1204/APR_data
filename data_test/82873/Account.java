import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

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
        NumberFormat round = new DecimalFormat("#.00");
        for (int i = 0; i < transactionList.size(); i++) {
            int t = i + 1;
            String tienGiaodich
                    = round.format(transactionList.get(i).getAmount());
            String tienDu
                    = round.format(transactionList.get(i).getBalance());
            if (transactionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + t + ": Nap tien $"
                                                + tienGiaodich + ". So du luc nay: $"
                                                + tienDu + ".");
            } else {
                System.out.println("Giao dich " + t + ": Rut tien $"
                                                + tienGiaodich + ". So du luc nay: $"
                                                + tienDu + ".");
            }
        }
    }


}
