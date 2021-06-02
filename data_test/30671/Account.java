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
            System.out.println("So tien ban rut vuot qua so du!");
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
            Transaction transaction = new Transaction(operation,amount,this.balance);
            transitionList.add(transaction);
        }
    }
    public void printTransaction()
    {
        int i;
        for (i = 0;i < transitionList.size();i++)
        {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT))
            {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",i + 1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            }
            else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW))
            {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",i + 1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
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
