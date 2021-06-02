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
            System.out.println("So tien ban nap vao khong hop le!");
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
        int dem = 0;
        if(this.transitionList.isEmpty()) return;
        else {
            DecimalFormat df = new DecimalFormat("#.00");
            for (Transaction i : this.transitionList) {
                dem++;
                if (i.getOperation().equals("deposit") )
                {
                    System.out.println("Giao dich " + dem + ": Nap tien $" +df.format( Math.round(i.getAmount()* 100.00)/100.0) + ". So du luc nay: $" + df.format(Math.round(i.getBalance()* 100.0)/100.0) + ".");
                }
                else if (i.getOperation().equals("withdraw") ){
                    System.out.println("Giao dich " + dem + ": Rut tien $" + df.format(Math.round(i.getAmount()* 100.00)/100.00 )+ ". So du luc nay: $" +df.format( Math.round(i.getBalance()* 100.0)/100.0) + ".");
                }
            }
        }
    }


}
