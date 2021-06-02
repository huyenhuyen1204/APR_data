import java.lang.reflect.Array;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    private void deposit(double amount)
    {
        if(amount > 0)
            balance += amount;
        else System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount)
    {
        if(amount > 0)
            if(amount <= balance)
                balance -= amount;
                        else System.out.println("So tien ban rut vuot qua so du!");
                        else System.out.println("So tien ban rut ra khong hop le!");
    }
    public void addTransaction(double amount,String operation )
    {
        if(operation == "deposit")
        {
            deposit(amount);
            Transaction transaction = new Transaction("deposit",amount,balance);
            transitionList.add(transaction);
        } else if (operation == "withdraw")
        {
            withdraw(amount);
            Transaction transaction = new Transaction("withdraw",amount,balance);
            transitionList.add(transaction);
        }
        else System.out.println("Yeu cau khong hop le!");

    }
    public void printTransaction()
    {
        String tmp;

        String result = "";
        for(int i  =0; i < transitionList.size(); i++)
        {
            if(transitionList.get(i).getOperation().equals("deposit"))
            {
                tmp = "Nap tien $";
            }
            else tmp = "Rut tien $";
            result = String.format("Giao dich %d: %s%.2f. So du luc nay: $%.2f.",i+1, tmp,
                    transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            System.out.println(result);
        }
    }
}
