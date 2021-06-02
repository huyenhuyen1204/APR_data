import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Nap tien.
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        transitionList.add(new Transaction("deposit", amount, balance));
    }

    /**
     * Rut tien.
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
        balance -= amount;
        transitionList.add(new Transaction("withdraw", amount, balance));
    }

    /**
     * Thuc hien giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (operation == "deposit") {
            deposit(amount);
        } else {
            if (operation == "withdraw") {
                withdraw(amount);
            } else {
                System.out.println("Yeu cau khong hop le!");
            }
        }
    }

    /**
     * In ra giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien ");
            }
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien ");
            }
            System.out.printf("$%.2f.", transitionList.get(i).getAmount());
            System.out.print(" So du luc nay: ");
            System.out.printf("$%.2f.\n", transitionList.get(i).getBalance());
        }
    }
}
