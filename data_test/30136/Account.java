import java.util.ArrayList;
import java.text.DecimalFormat;
public class Account{
    private double balance;
    ArrayList<String> transitionList = new ArrayList<>();
    private void deposit(double amount)
    {
        this.balance = this.balance + amount;
    }
    private void withdraw(double amount)
    {
        this.balance = this.balance - amount;
    }
    public void addTransaction(double amount, String operation)
    {
        DecimalFormat in = new DecimalFormat("#.00");
        if(operation.equals("deposit"))
        {
            if(amount <=0 ) System.out.print("So tien nap vao khong hop le!\n");
            else
            {
                deposit(amount);
                String a = ": Nap tien $" + in.format(amount) + ". So du luc nay: $" + in.format(this.balance) + ".";
                transitionList.add(a);
            }
        }
        else if(operation.equals("withdraw"))
        {
            if(amount <=0) System.out.print("So tien ban rut khong hop le!\n");
            else if(amount > this.balance) System.out.print("So tien ban rut vuot qua so du!\n");
            else
            {
                withdraw(amount);
                String a = ": Rut tien $" + in.format(amount) + ". So du luc nay: $" + in.format(this.balance) + ".";
                transitionList.add(a);
            }
        }
        else System.out.print("Yeu cau khong hop le!\n");
    }
    public void printTransaction()
    {
        for(int i=0;i<transitionList.size();i++)
        {
            System.out.println("Giao dich " + (i+1) + transitionList.get(i));
        }
    }
}