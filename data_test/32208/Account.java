import java.util.ArrayList;
import java.text.DecimalFormat;
public class Account{
    private double balance;
    private ArrayList<Transaction> transitionList;
    public Account(){
        this.transitionList=new ArrayList<Transaction>();
    }
    private void deposit (double amount)
    {
        if (amount <=0)
        {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            this.balance += amount;
        }
    }
    private void withdraw(double amount)
    {
        if(amount <=0)
        {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount > this.balance)
        {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else
        {
            this.balance -= amount;
        }
    }
    public void addTransaction(double amount , String operation)
    {
        if(operation.equals("deposit") ){
            deposit(amount);
            this.transitionList.add(new Transaction("deposit", amount, this.balance));

        }
        else if(operation.equals("withdraw") ) {
            withdraw(amount);
            this.transitionList.add(new Transaction("withdraw", amount, this.balance));
        }
        else
            System.out.println("Yeu cau khong hop le!");
    }
    public void printTransaction()
    {
        
    }


}
