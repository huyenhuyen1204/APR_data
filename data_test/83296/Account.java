import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += roundAvoid(amount, 2);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (this.balance - amount < 0) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= roundAvoid(amount, 2);
        }
    }

    /**
     * add trans.
     * @param amount sotien
     * @param operation loai giao dich
     */

    public void addTransaction(double amount, String operation) {
        if (! (operation.toUpperCase().compareTo(Transaction.DEPOSIT) == 0
                || operation.toUpperCase().compareTo(Transaction.WITHDRAW) == 0)) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.toUpperCase().compareTo(Transaction.DEPOSIT) == 0) {
            deposit(amount);
            transitionList.add(new Transaction(operation, roundAvoid(amount, 2), this.balance));
        } else if (operation.toUpperCase().compareTo(Transaction.WITHDRAW) == 0) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, roundAvoid(amount, 2), this.balance));
        }
    }

    /**
     * in ra giao dich.
     */

    public void printTransaction() {
        int i = 1;
        for (Transaction trans:transitionList) {
            if (trans.getOperation().toUpperCase().compareTo(Transaction.DEPOSIT) == 0) {
                System.out.format("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        i, trans.getAmount(), trans.getBalance());
            } else {
                System.out.format("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        i, trans.getAmount(), trans.getBalance());
            }
            i++;
        }
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
