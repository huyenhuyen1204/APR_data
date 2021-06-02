import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions;
    
    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
    }
    
    private void deposit(double amount) {
        if (amount <= 0) {System.out.println("So tien ban nap vao khong hop le!"); return;}
        balance += amount;
        transactions.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }
    
    private void withdraw(double amount) {
        if (amount <= 0) { System.out.println("So tien ban rut ra khong hop le!"); return; }
        if (amount > balance) { System.out.println("So tien ban rut vuot qua so du!"); return; }
        balance -= amount;
        transactions.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }
    
    public void addTransaction(double amount, String operation)  {
        if (operation.equals(Transaction.DEPOSIT)) { deposit(amount); return; }
        if (operation.equals(Transaction.WITHDRAW)) { withdraw(amount); return; }
        System.out.println("Yeu cau khong hop le!");
    }
    
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("Giao dich ").append(i + 1). append(": ");
            builder.append(transactions.get(i));
            System.out.println(builder.toString());
        }
    }
    
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
