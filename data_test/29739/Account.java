import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {
    private double balance;
    private List<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance)
                balance -= amount;
            else
                System.out.println("So tien ban rut vuot qua so du!");
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else
            System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        int i = 1;
        String op;
        for (Transaction t: transitionList) {
            op = t.getOperation().equals(Transaction.WITHDRAW) ? "Rut tien" : "Nap tien";
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n", i++, op, t.getAmount(), t.getBalance());
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
