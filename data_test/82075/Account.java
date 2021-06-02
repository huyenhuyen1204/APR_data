import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;
    
    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }
    
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }
    
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }
    
    /**
     * Add one transaction.
     */
    public void addTransaction(double amount, String operation)  {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            return;
        }
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            return;
        }
        System.out.println("Yeu cau khong hop le!");
    }
    
    
    /**
     * Print transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("Giao dich ").append(i + 1). append(": ");
            builder.append(transitionList.get(i));
            System.out.println(builder.toString());
        }
    }
    
    /**
     * Unit test.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
