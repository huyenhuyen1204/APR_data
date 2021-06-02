
public class Transaction {
	private String operation;
	private double amount, balance;
	final static String DEPOSIT = "deposit", WITHDRAW = "withdraw";
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getAmount() {
		return Math.round(amount*100)/100.00;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return Math.round(balance*100)/100.00;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	Transaction(){};
	Transaction(String operation, double amount, double balance){
		this.operation = operation;
		this.amount = amount;
		this.balance = balance;
	}
}
