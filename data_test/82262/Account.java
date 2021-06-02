import java.text.DecimalFormat;
import java.util.ArrayList;


public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /** deposit.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** withdraw.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /** add transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** print transaction.
     */

    public void printTransaction() {
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 0; i < transitionList.size(); ++i) {
            System.out.println("Giao dich " + (i + 1) + ": "
            + (transitionList.get(i).getOperation().equals("deposit")? "Nap tien $" : "Rut tien $")
            + df.format(transitionList.get(i).getAmount()) + ". So du luc nay: $"
            + df.format(transitionList.get(i).getBalance()) + "."
            );
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
