import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private int count = 1;
    private ArrayList<String> transaction = new ArrayList<>();
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private BigDecimal round(double value) {
        BigDecimal a = new BigDecimal(value);
        return a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**a.
     * @param amount a
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            String result = "Giao dich " + count + ": Nap tien " + "$"
                    + round(amount) + ". So du luc nay: " + "$" + round(balance) + ".";
            count += 1;
            transaction.add(result);
        }
    }

    /**a.
     * @param amount a
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            String result = "Giao dich " + count + ": Rut tien " + "$"
                    + round(amount) + ". So du luc nay: " + "$" + round(balance) + ".";
            count += 1;
            transaction.add(result);
        }
    }

    /**a.
     * @param amount a
     * @param operation a
     */
    public void addTransaction(double amount, String operation) {
        switch (operation) {
            case Transaction.DEPOSIT:
                deposit(amount);
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * a.
     */
    public void printTransaction() {
        for (String s : transaction) {
            System.out.println(s);
        }
    }
}
