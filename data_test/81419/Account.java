import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * in ds.
     */
    public void printTransaction() {
        DecimalFormat f = new DecimalFormat("##.00");
        int i = 0;
        for (Transaction e : transitionList) {
            i++;
            String str = "Giao dich " + i + ":";
            if (e.getOperation()
                    .compareTo(Transaction.DEPOSIT) == 0) {
                str += " Nap tien " + e.getAmount()
                        + ". So du luc nay: " + f.format(e.getAmount()) + ".";
            } else  {
                str += " Rut tien " + e.getAmount()
                        + ". So du luc nay: " + f.format(e.getBalance()) + ".";
            }
            System.out.println(str);
        }
    }

    /**
     * rut tien.
     * @param amount so tine
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        this.balance += (double) Math.ceil(amount * 100)/ 100;
        Transaction e = new Transaction(Transaction.DEPOSIT, amount, this.balance);
        transitionList.add(e);
    }

    /**
     * rut tien
     * @param amount so tien
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        this.balance -= (double) Math.ceil(amount * 100)/ 100;
        Transaction e = new Transaction(Transaction.WITHDRAW, amount, this.balance);
        transitionList.add(e);
    }

    /**
     * them gd.
     * @param amount so tien
     * @param operation hd
     */
    public void addTransaction(double amount, String operation) {
        if (operation.compareTo(Transaction.DEPOSIT) == 0) {
            deposit(amount);
            return;
        }

        if (operation.compareTo(Transaction.WITHDRAW) == 0) {
            withdraw(amount);
            return;
        }

        System.out.println("Yeu cau khong hop le!");
    }
}
