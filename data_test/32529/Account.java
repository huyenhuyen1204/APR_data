import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Spliterator;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList();

    private void deposit(double amount)
    {
        if (amount<=0) System.out.println("So tien ban nap vao khong hop le!");
        else
            balance += amount;
    }

    private void withdraw(double amount)
    {
        if (amount<=0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount>balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else
            balance-= amount;

    }

    public void addTransaction(double amount, String operation)
    {
        if (operation.equals(Transaction.DEPOSIT))
        {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        }
        else if (operation.equals(Transaction.WITHDRAW))
        {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        }
        else
        {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction()
    {
        DecimalFormat format = new DecimalFormat("0.00");
        int dem =1;
        for (Transaction val:  transitionList)
        {
            if (val.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.println("Giao dich " + dem + ": Nap tien $" + format.format(val.getAmount()) + ". So du luc nay: $" + format.format(val.getBalance()) +".");
            }
            else
            {
                System.out.println("Giao dich " + dem + ": Rut tien $" + format.format(val.getAmount()) + ". So du luc nay: $" + format.format(val.getBalance()) +".");
            }
            dem++;
        }

    }

    public static void main(String[] args) {
        /*Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();*/
    }
}
