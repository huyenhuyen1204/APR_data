
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {

    static DecimalFormat format = new DecimalFormat("0.00");
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        } else balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount >= balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        } else balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        amount = (double)Math.round(amount*100)/100;

        if (operation != "deposit" && operation != "withdraw") {
            System.out.println("Yeu cau khong hop le!");
            return;
        } else if (operation.equals("deposit") ) {
            deposit(amount);

        } else if (operation.equals("withdraw") ) {
            withdraw(amount);
        }

        Transaction transaction = new Transaction(amount, operation, balance);
        transitionList.add(transaction);
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i+1) + ": ");

            if (transitionList.get(i).getOperation() == "deposit") System.out.print("Nap tien $");
            else if (transitionList.get(i).getOperation() == "withdraw") System.out.print("Rut tien $");

            System.out.println(format.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + format.format(transitionList.get(i).getBalance()) + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
