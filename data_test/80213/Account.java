import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

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

        boolean check = false;
        if (operation.equals(Transaction.WITHDRAW)) {
            double temp = balance;
            withdraw(amount);

            if (balance == temp - amount) {
                check = true;
            }
        } else if (operation.equals(Transaction.DEPOSIT)) {
            double temp = balance;
            deposit(amount);
            if (balance == temp + amount) {
                check = true;
            }
        }

        if (check) {
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        }
    }

    /**
     * abc.
     */
    public String round(double amount) {
        double a = (double) (Math.round(amount * 100)) / 100;
        double temp = a - Math.round(a);
        if (temp == 0) {
            return "" + a + '0';
        }

        return "" + a;
    }

    /**
     * abc.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); ++i) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $");
            } else {
                System.out.print("Rut tien $");
            }

            System.out.print("" + round(transitionList.get(i).getAmount())
                    + ". " + "So du luc nay: $"
                    + round(transitionList.get(i).getBalance())
                    + '.');
            System.out.println("");
        }
    }
}
