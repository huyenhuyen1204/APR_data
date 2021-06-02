//package Transaction;
import java.util.ArrayList;

public class Account
{
    //Variables
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    //Methods
    public Account()
    {

    }
    private void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else
        {
            this.balance = this.balance + amount;
        }
    }
    private void withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount > this.balance)
        {
            System.out.println("So tien ban rut vuot qua so du");
        }
        else
        {
            this.balance = this.balance - amount;
        }
    }
    public void addTransaction(double amount,String operation)
    {
        if(!operation.equals("withdraw") && !operation.equals("deposit"))
        {
            System.out.print("Yeu cau khong hop le!");
        }
        else
        {
            if(operation.equals("deposit"))
            {
                deposit(amount);
            }
            else if(operation.equals("withdraw"))
            {
                withdraw(amount);
            }
            Transaction add = new Transaction(operation,amount,this.balance);
            transitionList.add(add);
        }
    }
    public void printTransaction()
    {
        int i;
        for (i = 0;i < transitionList.size();i++)
        {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT))
            {
                double a = transitionList.get(i).getBalance();
                double b = transitionList.get(i).getAmount();
                System.out.println("Giao dich " + i + 1 + ": Nap tien $" + transitionList.get(i).getAmount() + ". So du luc nay: $" + Math.round((a + b) * 100) / 100);
            }
            else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW))
            {
                double a = transitionList.get(i).getBalance();
                double b = transitionList.get(i).getAmount();
                System.out.println("Giao dich " + i + 1 + ": Rut tien $" + transitionList.get(i).getAmount() + ". So du luc nay: $" + Math.round((a - b) * 100) / 100);
            }
        }
    }
    public static void main(String[] args)
    {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000.00,"withdraw");
        acc.printTransaction();
    }
}
