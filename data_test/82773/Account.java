import java.util.ArrayList;
import java.util.List;

public class Account extends Transaction {

    private double balance = 0;

    public Account() {

    }

    /**
     * constructor.
     */
    public Account(String operation, double amount, double balance) {
        super(operation, amount, balance);
    }

    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * nap tien.
     * @param amount so tien
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        if (transitionList.size() == 0) {
            Transaction x = new Transaction();
            x.setAmount(amount);
            x.setBalance(getBalance() + amount);
            x.setOperation(getDeposit());
            transitionList.add(x);
        } else {
            Transaction x = new Transaction();
            x.setAmount(amount);
            x.setBalance(transitionList.get(transitionList.size() - 1).getBalance() + amount);
            x.setOperation(getDeposit());
            transitionList.add(x);
        }
    }

    /**
     * rut tien.
     * @param amount so tien
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (transitionList.size() == 0) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        } else {
            if (transitionList.get(transitionList.size() - 1).getBalance() < amount) {
                System.out.println("So tien ban rut vuot qua so du!");
                return;
            }
        }
        Transaction x = new Transaction();
        x.setAmount(amount);
        x.setBalance(transitionList.get(transitionList.size() - 1).getBalance() - amount);
        x.setOperation(getWithdraw());
        transitionList.add(x);
    }

    /**
     * them giao dich.
     * @param amount so tien
     * @param operation kieu giao dich
     */
    public void addTransaction(double amount, String operation) {
        if (operation != getDeposit() && operation != getWithdraw()) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation == getDeposit()) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    /**
     * in giao dich.
     */
    public void printTransaction() {
        int cnt = 1;
        for (Transaction i : transitionList) {
            if (i.getOperation() == getDeposit()) {
                System.out.println("Giao dich " + cnt + ": Nap tien $" 
                + String.format("%.2f", i.getAmount()) + ". So du luc nay: $" 
                + String.format("%.2f", i.getBalance()) + ".");
            } else {
                System.out.println("Giao dich " + cnt + ": Rut tien $" 
                + String.format("%.2f", i.getAmount()) + ". So du luc nay: $" 
                + String.format("%.2f", i.getBalance()) + ".");
            }
            cnt++;
        }
    }
}
