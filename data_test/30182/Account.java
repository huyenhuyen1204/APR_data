import java.util.ArrayList;
public class Account{
    private double balance ;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
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
        if(operation.equals(Transaction.getDEPOSIT()))
        {
            if(amount <=0 ) System.out.print("So tien ban nap vao khong hop le!\n");
            else
            {
                deposit(amount);
                Transaction a = new Transaction(": Nap tien $", amount, this.balance);
                transitionList.add(a);
            }
        }
        else if(operation.equals(Transaction.getWITHDRAW()))
        {
            if(amount <=0) System.out.print("So tien ban rut ra khong hop le!\n");
            else if(amount > this.balance) System.out.print("So tien ban rut vuot qua so du!\n");
            else
            {
                withdraw(amount);
                Transaction a = new Transaction(": Rut tien $", amount, this.balance);
                transitionList.add(a);
            }

        }
        else System.out.print("Yeu cau khong hop le!\n");
    }
    public void printTransaction()
    {
        for(int i=0;i<transitionList.size();i++)
        {
            System.out.print("Giao dich " + (i+1)  + transitionList.get(i).getOperation());
            System.out.printf("%.2f",transitionList.get(i).getAmount());
            System.out.print(". So du luc nay: $");
            System.out.printf("%.2f",transitionList.get(i).getBalance());
            System.out.println(".");
        }
    }
}