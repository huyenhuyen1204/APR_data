import java.util.ArrayList;

public class Account {
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private ArrayList<Transaction> transitionList;
	public Account(){
		transitionList = new ArrayList<Transaction>();
	};
	
	private void deposit(double amount)
	{	
		if (amount <= 0)
			System.out.println( "So tien ban nap vao khong hop le!");
		else {
			this.balance+= amount;
			Transaction e = new Transaction(Transaction.DEPOSIT, amount, balance);
			transitionList.add(e);
		}
	}
	private void withdraw(double amount)
	{	
		if (amount <= 0)
			System.out.println( "So tien ban nap vao khong hop le!");
		else if (amount > this.balance)
			System.out.println( "So tien ban rut vuot qua so du!");
		else 
			{
				this.balance -= amount;
				Transaction e = new Transaction(Transaction.WITHDRAW, amount, balance);
				transitionList.add(e);
			}
		
	}
	public void addTransaction(double amount, String operation) {
		if ( (operation != Transaction.DEPOSIT) && (operation != Transaction.WITHDRAW))
		{
			System.out.println( "Yeu cau khong hop le!");
			return;
		}
		if (operation == Transaction.DEPOSIT) deposit(amount);
		if (operation == Transaction.WITHDRAW) withdraw(amount);
	}
	public void printTransaction() {
		int cnt = 0;
		for(Transaction t : transitionList) {
			cnt++;
			System.out.println("Giao dich " + cnt + ": Nap tien $ " + t.getAmount() + ".");
			System.out.println(" So du luc nay: $ " + t.getBalance() + ".");
		}
	}
	public static void main(String[] args) 
	{
		Account acc= new Account();  
		acc.addTransaction(2000.255,"deposit");  
		acc.addTransaction(1000,"withdraw");  
		acc.printTransaction();
	}
}
