import java.util.ArrayList;


public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    /**
     *  .
     */
    public Account() {
        this.balance = 0;
        this.transitionList  = new ArrayList<>();;
    }

    /**
     *  .
     * @param amount .
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     *  .
     * @param amount .
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     *  .
     * @param amount .
     * @param operation .
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals("deposit")) {
            deposit(amount);
            transitionList.add(new Transaction("Nap tien ", amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            transitionList.add(new Transaction("Rut tien ", amount, balance));
        }
    }

    /**
     *  .
     */
    public void printTransaction() {
        String print = ". So du luc nay: $";
        int n = transitionList.size();
        Transaction transaction;
        String s;
        double amount;
        double balance;
        String amountStr;
        String balacenStr;
        for (int i = 0; i < n; i++) {
            transaction = transitionList.get(i);
            s = transaction.getOperation();
            amount = (double) Math.round(transaction.getAmount() * 100) / 100;
            balance = (double) Math.round(transaction.getBalance() * 100) / 100;
            if ((amount - (int) amount) == 0) {
                amountStr = String.valueOf(amount) + "0";
            } else {
                amountStr = String.valueOf(amount);
            }
            if ((balance - (int) balance) == 0) {
                balacenStr = String.valueOf(balance) + "0";
            } else {
                balacenStr = String.valueOf(balance);
            }
            System.out.println("Giao dich " + (i + 1) + ": " + s + "$" + amountStr
                                + print + balacenStr + ".");
        }
    }
}
