import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 10/26/19
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private double balance = 0;
    ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else balance += amount;
    }

    private void withdraw(double amount) {
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if(amount > balance) System.out.println("So tien ban rut vuot qua so du!");
            balance -= amount;
    }

    public void addTransaction(double amount, String operation) {

        if(operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation,amount,balance));
        }
        if(operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation,amount,balance));
        }
        if(!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW))  System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        // %.2f
        int i = 1;
        for(Transaction t : transitionList)  {
            String o = "";
            if(t.getOperation().equals(Transaction.DEPOSIT)) o = "Nap";
            if(t.getOperation().equals(Transaction.WITHDRAW)) o = "Rut";
            System.out.printf("Giao dich %d: %s tien $%.2f. So du luc nay: $%.2f.\n",i++ , o, t.getAmount(), t.getBalance());

        }
    }
}
