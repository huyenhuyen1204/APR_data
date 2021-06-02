import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> TransactionList = new ArrayList<>();

    private void deposit(double amount)
    {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else
        {
            Transaction depo = new Transaction("deposit", amount, balance + amount);
            TransactionList.add(depo);
        }
    }

    private void withdraw(double amount)
    {
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if(balance - amount < 0) System.out.println("So tien ban rut vuot qua so du!");
        else
        {
            Transaction withd = new Transaction(Transaction.WITHDRAW,amount, balance - amount);
            TransactionList.add(withd);
        }
    }

    public void addTransaction(double amount, String operation)
    {
        if(operation.equals(Transaction.DEPOSIT))
        {
            deposit(amount);
        }
        else if(operation.equals(Transaction.WITHDRAW))
        {
            withdraw(amount);
        }
        else System.out.println("Giao dich khong hop le!");
    }

    public static double rou(double value)
    {
        return (double) Math.round(value*100)/100;
    }

    public  void printTransaction()
    {
        int size = TransactionList.size();
        for(int i = 1; i<= size; i++)
        {
            System.out.print("Giao dich " + i + ": ");
            if(TransactionList.get(i).getOperation().equals(Transaction.WITHDRAW))
            {
                System.out.print("Rut tien $");
            }
            else System.out.print("Nap tien $");

            System.out.print( rou(TransactionList.get(i).getAmount()) + ". " );
            System.out.println("So du luc nay: $" + rou(TransactionList.get(i).getBalance()) +". ");
        }
    }

}
