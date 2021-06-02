import java.util.ArrayList;
/**
 * Account
 */
public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount)
    {
        if (amount <= 0)  
            System.out.println("So tien ban nap vao khong hop le!");
        else this.balance += amount;
    }

    private void withdraw(double amount)
    {
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else
            this.balance -= amount;
    }

    public void addTransaction(double amount, String operation)
    {
        if (operation.equals(Transaction.DEPOSIT))
        {
            // if balance didn't change after transaction, it means the transaction was unsuccessful 
            // and we won't record it in the list
            double prevBalance = this.balance;
            deposit(amount);
            double curBalance = this.balance;
            if (curBalance != prevBalance)
            {
                Transaction t = new Transaction(operation, amount, this.balance);
                transitionList.add(t);
            }
        }
        else if (operation.equals(Transaction.WITHDRAW))
        {
            double prevBalance = this.balance;
            withdraw(amount);
            double curBalance = this.balance;
            if (curBalance != prevBalance)
            {
                Transaction t = new Transaction(operation, amount, this.balance);
                transitionList.add(t);
            }
        }
        else
            System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction()
    {
        for (int i = 1; i <= transitionList.size(); i++)
        {
            System.out.print("Giao dich " + i + ": ");
            if (transitionList.get(i-1).getOperation().equals(Transaction.DEPOSIT))
            {
                System.out.printf("Nap tien $%.2f. ", transitionList.get(i-1).getAmount());
                System.out.printf("So du luc nay: $%.2f.\n", transitionList.get(i-1).getBalance());
            }
            else if (transitionList.get(i-1).getOperation().equals(Transaction.WITHDRAW))
            {
                System.out.printf("Rut tien $%.2f. ", transitionList.get(i-1).getAmount());
                System.out.printf("So du luc nay: $%.2f.\n", transitionList.get(i-1).getBalance());
            }
        }
    }
}