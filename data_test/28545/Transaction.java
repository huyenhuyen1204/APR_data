/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 10/26/19
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    final public static String DEPOSIT = "deposit";
    final public static String WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
