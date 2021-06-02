import java.util.ArrayList;

/**
 * Created by CCNE on 05/11/2019.
 */
public class Account extends Transaction {
    int count;
    private double balance;
    private ArrayList<Transaction> ListOperation ;
    private void deposit(double amount)     {
        if(amount > 0)  balance+=amount;
        else System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount)    {
        if(amount>0&& amount < balance) balance+= amount;
        else {
            if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
            else System.out.println("So tien ban rut vuot qua so du!");
        }
    }
    public void  addTransaction(double amount, String operation)    {
        if(operation==DEPOSIT) {
            deposit(amount);
            Transaction a =new Transaction(DEPOSIT,amount,this.balance);
            ListOperation.add(a);
            count ++;
        }
        else if(operation==WITHDRAW)    {

            withdraw(amount);
            Transaction b =new Transaction(WITHDRAW,amount,this.balance);
            ListOperation.add(b);
           count ++;
        }
        else System.out.println("Yeu cau khong hop le!");
    }
    public void printTransaction() {
        for (int i = 0; i < count; i++) {
            System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + ListOperation.get(i).getAmount() + "." + " So du luc nay: $" + ListOperation.get(i).getBalance());
        }

    }
}
