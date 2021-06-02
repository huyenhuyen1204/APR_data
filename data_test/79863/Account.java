import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Cmt.
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * Cmt.
     */
    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * Cmt.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equalsIgnoreCase("deposit") && !operation.equalsIgnoreCase("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equalsIgnoreCase("deposit")) {
                deposit(amount);
            }
            if (operation.equalsIgnoreCase("withdraw")) {
                withdraw(amount);
            }
            transitionList.add(new Transaction(operation, amount, balance));
        }
    }

    /**
     * Cmt.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String operation = "";
            if (transitionList.get(i).getOperation().equalsIgnoreCase("deposit")) {
                operation = "Nap tien";
            } else {
                operation = "Rut tien";
            }
            System.out.printf("Giao dich %d: %s $%.02f. " + "So du luc nay: $%.02f.\n",
                    i, operation, transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
        }
    }

    /**
     * Cmt.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
