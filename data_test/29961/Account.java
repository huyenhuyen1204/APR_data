//package Transaction;
import java.util.ArrayList;

public class Account
{
    //Variables
    private double balance;
    private ArrayList<Transaction> Transactions = new ArrayList<Transaction>();

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
            this.balance = amount;
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
        Transaction T1 = new Transaction(operation,amount,balance);
        T1.setAmount(amount);
        T1.setOperation(operation);
        if (operation != "DEPOSIT" && operation != "WITHDRAW")
        {
            System.out.print("Yeu cau khong hop le!");
        }
        else if (operation == "DEPOSIT")
        {
            deposit(amount);
        }
        else
        {
            withdraw(amount);
        }
        Transactions.add(T1);
    }
    public void printTransaction()
    {
        int i;
        for (i = 0;i < Transactions.size();i++)
        {
            if (Transactions.get(i).getOperation() == "deposit")
            {
                double a = Transactions.get(i).getBalance();
                System.out.println("Giao dich " + i + ": Nap tien $" + Transactions.get(i).getBalance() + ". So du luc nay: $" + Math.round(a * 100) / 100);
            }
            else
            {
                double a = Transactions.get(i).getBalance();
                double b = Transactions.get(i).getAmount();
                System.out.println("Giao dich " + i + ": Rut tien $" + Transactions.get(i).getAmount() + ". So du luc nay: $" + Math.round((a - b) * 100) / 100);
            }
        }
    }
}
