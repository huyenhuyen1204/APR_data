import java.util.ArrayList;
import java.text.DecimalFormat;
public class Account {
    DecimalFormat df = new DecimalFormat("#.00");
    private double balance;
    private ArrayList<Transaction> transitionList;
    public Account()
    {
        this.balance = 0;
        this.transitionList = new ArrayList<Transaction>();
    }
    private void deposit(double amount)
    {
        if(amount<=0) System.out.println("So tien ban nap vao khong hop le!");
        else this.balance = amount + this.balance;
    }
    private void withdraw(double amount)
    {
        if(amount<=0) System.out.println("So tien ban nap vao khong hop le!");
        else {
            if(amount>this.balance) System.out.println("So tien ban rut vuot qua so du!");
            else this.balance = this.balance - amount ;
        }
    }
    public void addTransaction(double amount,String operation)
    {
        if(operation != "deposit" && operation != "withdraw") System.out.println("Yeu cau khong hop le!");
        else
        {
            Transaction t1 = new Transaction(operation,amount,this.balance);
            transitionList.add(t1);
        }
    }
    public void printTransaction()
    {
        for(int i=0;i<transitionList.size();i++)
        {
            System.out.print("Giao dich "+(i+1)+": ");
            if(transitionList.get(i).getOperation() == "deposit"){
                deposit(transitionList.get(i).getAmount());
                System.out.print("Nap tien");
            }
            if(transitionList.get(i).getOperation() == "withdraw"){
                withdraw(transitionList.get(i).getAmount());
                System.out.print("Rut tien");
            }
            System.out.println(" $"+(df.format(transitionList.get(i).getAmount())+". So du luc nay: "+(df.format(this.balance))+"."));
        }
    }

}
