import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {

	static DecimalFormat format = new DecimalFormat("0.00"); 
	private double balance;
	private ArrayList<Transaction> transitionList = new ArrayList<>();
	private void deposit(double amount)
	{
		if(amount > 0) {
			this.balance = this.balance + amount;
		}
		else {
			System.out.println("So tien ban nap vao khong hop le!");
		}
	}
	private void withdraw(double amount)
	{
		if(amount <= 0) {
			System.out.println("So tien ban rut ra khong hop le!");
		}
		else if(amount > this.balance) {
			System.out.println("So tien ban rut vuot qua so du!");
		}
		else {
			this.balance = this.balance - amount;
		}
	}
	public void addTransaction(double amount, String operation)
	{
		if(!operation.equals("deposit") && !operation.equals("withdraw"))
		{
			System.out.println("Yeu cau khong hop le!");
		}
		else if(operation.equals("deposit"))
		{
			amount = (double)Math.round(amount * 100) / 100;
			deposit(amount);
			Transaction transaction = new Transaction(operation, amount, this.balance);
			transitionList.add(transaction);
		}
		else if(operation.equals("withdraw")) {
			amount = (double)Math.round(amount * 100) / 100;
			withdraw(amount);
			Transaction transaction = new Transaction(operation, amount, this.balance);
			transitionList.add(transaction);
		}
	}
	
	public void printTransaction()
	{
		for(int i = 0; i < transitionList.size(); i++)
		{
			if(transitionList.get(i).getOperation().equals("deposit"))
			{
				System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + format.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + format.format(transitionList.get(i).getBalance()) + ".");
			}
			if(transitionList.get(i).getOperation().equals("withdraw"))
			{
				System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + format.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + format.format(transitionList.get(i).getBalance()) + ".");
			}
		}
	}
	
}
