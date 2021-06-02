import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> transitions = new ArrayList<>();
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * deposit.
     *
     * @param amount a.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * withdraw.
     *
     * @param amount a.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        }
    }

    /**
     * addTransaction.
     *
     * @param amount    a.
     * @param operation o.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            String tmp = "Giao dich " + Integer.toString(transitions.size() + 1) + ": "
                    + "Nap tien $" + String.format("%.2f", amount) + ". "
                    + "So du luc nay: $" + String.format("%.2f", balance) + ".";
            if (!transitions.isEmpty()) {
                tmp = "\n" + tmp;
            }
            transitions.add(tmp);
        } else {
            if (operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
                String tmp = "Giao dich " + Integer.toString(transitions.size() + 1) + ": "
                        + "Rut tien $" + String.format("%.2f", amount) + ". "
                        + "So du luc nay: $" + String.format("%.2f", balance) + ".";
                if (!transitions.isEmpty()) {
                    tmp = "\n" + tmp;
                }
                transitions.add(tmp);
            } else {
                System.out.println("Yeu cau khong hop le!");
            }
        }
    }

    /**
     * print.
     */
    public void printTransaction() {
        for (String transaction : transitions) {
            System.out.print(transaction);
        }
    }
}
