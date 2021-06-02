import java.util.ArrayList;

/**
 *  .
 * @author Lê Công Nam .
 */
public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     *  .
     * @param amount .
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.setBalance(this.getBalance() + amount);
        }
    }

    /**
     *  .
     * @param amount .
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.getBalance()) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    /**
     *  .
     * @param amount .
     * @param operation .
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            Transaction deposit = new Transaction("deposit", amount, this.getBalance());
            transitionList.add(deposit);
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            Transaction withdraw = new Transaction("withdraw", amount, this.getBalance());
            transitionList.add(withdraw);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     *  .
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double amount = transitionList.get(i).getAmount();
            double balance = transitionList.get(i).getBalance();
            String dps = transitionList.get(i).getAmount() % 10 == 0
                    ? (double) Math.round(amount * 100) / 100 + "0"
                    : (double) Math.round(amount * 100) / 100 + "";
            String blc = transitionList.get(i).getBalance() % 10 == 0
                    ? (double) Math.round(balance * 100) / 100 + "0"
                    : (double) Math.round(balance * 100) / 100 + "";
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                        + dps + ". So du luc nay: $" + blc + ".");
            } else if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $"
                        + dps + ". So du luc nay: $" + blc + ".");
            }
        }
    }

    /**
     *  .
     * @return .
     */
    public double getBalance() {
        return balance;
    }

    /**
     *  .
     * @param balance .
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
