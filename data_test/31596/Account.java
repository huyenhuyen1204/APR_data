import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount)
    {
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else
        {
            balance += amount;
            Transaction depo = new Transaction("deposit", amount, balance);
            transitionList.add(depo);
        }
    }

    private void withdraw(double amount)
    {
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if(balance - amount < 0) System.out.println("So tien ban rut vuot qua so du!");
        else
        {
            balance -= amount;
            Transaction withd = new Transaction(Transaction.WITHDRAW,amount, balance);
            transitionList.add(withd);
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
        else System.out.println("Yeu cau khong hop le!");
    }

    public static double rou(double value)
    {
        return (double) Math.round(value*100)/100;
    }

    public  void printTransaction()
    {
        int size = transitionList.size();
        for(int i = 0; i< size; i++)
        {
            System.out.print("Giao dich ");
            System.out.print(i+1 + ": ");
            if(transitionList.get(i).getOperation().equals(Transaction.WITHDRAW))
            {
                System.out.print("Rut tien $");
            }
            else System.out.print("Nap tien $");

            System.out.printf("%.2f", rou(transitionList.get(i).getAmount()) );
            System.out.print(". So du luc nay: $" );
            System.out.printf("%.2f", rou(transitionList.get(i).getBalance()) );
            System.out.println(".");
        }
    }

}
