import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> historyTransaction = new ArrayList<>();

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount < 0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount > this.balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else {
            this.balance -= amount;
        }
    }

    public void addTransaction (double amount, String operation){
        if (operation == "deposit"){
            this.deposit(amount);
        }
        else {
            this.withdraw(amount);
        }
        Transaction transaction = new Transaction(operation, amount, this.balance);
        historyTransaction.add(transaction);
    }

    public void printTransaction() {
        for(int i = 0; i < historyTransaction.size(); ++i){
            System.out.println("Giao dich " + (i + 1) + ": " + historyTransaction.get(i).toString());
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }

}
