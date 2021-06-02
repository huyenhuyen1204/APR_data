import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance = 0;
    ArrayList<Transaction> listTransaction = new ArrayList<Transaction>();
    
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }    
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.WITHDRAW && operation != Transaction.DEPOSIT) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
            }
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            }
            listTransaction.add(new Transaction(operation, amount, balance));   
        }
    }

    public void printTransaction() {
        for (int i = 0; i < listTransaction.size(); i++) {
            if (listTransaction.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                DecimalFormat df = new DecimalFormat("##.##");
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                + df.format(Math.round(listTransaction.get(i).getAmount() * 100.0) / 100.0)
                + ". So du luc nay: $" 
                + df.format(Math.round(listTransaction.get(i).getBalance() * 100.0) / 100.0) + ".");
            }
            if (listTransaction.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                DecimalFormat df = new DecimalFormat("##.00##");
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $" 
                + df.format(Math.round(listTransaction.get(i).getAmount() * 100.0) / 100.0) 
                + ". So du luc nay: $" 
                + df.format(Math.round(listTransaction.get(i).getBalance() * 100.0) / 100.0) + ".");
            }
        }   
    }

    // public static void main(String[] args) {
    //     Account acc= new Account();  
    //     acc.addTransaction(2000.255,"deposit");  
    //     acc.addTransaction(1000,"withdraw");  
    //     acc.printTransaction();
    // }
}
