import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transHis = new ArrayList<>();

    /**
     * abc.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        balance += amount;
    }

    /**
     * abc.
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
     * abc.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT)
                && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }

        Transaction trans = new Transaction(operation, amount, balance);
        transHis.add(trans);
    }

    /**
     * abc.
     */
    public double round(double amount) {
        return (double) (Math.round(amount * 100)) / 100;
    }

    /**
     * abc.
     */
    public void printTransaction() {
        for (int i = 0; i < transHis.size(); ++i) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transHis.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }

            System.out.print("" + round(transHis.get(i).getAmount())
                    + ". " + "So du luc nay: "
                    + round(transHis.get(i).getBalance())
                    + '.');
            System.out.println("");
        }
    }
}
