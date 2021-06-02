import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction>  transactionList = new ArrayList<>();

    /**
     * in ds.
     */
    public void printTransaction() {
        int i = 0;
        for (Transaction e : transactionList) {
            i++;
            String str = "Giao dich " + i + ":";
            if (e.getOperation().
                    compareTo(Transaction.DEPOSIT) == 0) {
                str += " Nap tien " + e.getAmount()
                        + ". So du luc nay: " + e.getBalance() + ".";
            } else  {
                str += " Rut tien " + e.getAmount()
                        + ". So du luc nay: " + e.getBalance() + ".";
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

        this.balance += amount;
        Transaction e = new Transaction(Transaction.DEPOSIT, amount, this.balance);
        transactionList.add(e);
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

        this.balance -= amount;
        Transaction e = new Transaction(Transaction.WITHDRAW, amount, this.balance);
        transactionList.add(e);
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
