import java.util.ArrayList;
public class Account{
    private double balance;
    ArrayList<String> arr = new ArrayList<>();
    private void deposit(double amount)
    {
        if(amount < 0) System.out.print("so tien ban nap vao khong hop le!") ;
        else
        {
            this.balance = this.balance + amount;
            arr.add(": Nap tien $");
        }
    }
    private void withdraw(double amount)
    {
        if(amount < 0) System.out.print("So tien ban rut khong hop le!");
        else if(amount > this.balance) System.out.print("So tien ban rut vuot qua so du!");
        else
        {
            this.balance = this.balance - amount;
            arr.add(": Rut tien $");
        }
    }
    public void addTransaction(double amount, String operation)
    {
        if(operation.equals("deposit")) deposit(amount);
        else if(operation.equals("withdraw")) withdraw(amount);
        else System.out.print("Yeu cau khong hop le!");
    }
    public void printTransaction()
    {
        for(int i=0;i<arr.size();i++)
        {
            System.out.print("Giao dich " + (i+1) + arr.get(i) + this.balance + ". So du luc nay: $" + Math.round(this.balance*100.0)/100.0 + "." + "\n");
        }
    }
}
