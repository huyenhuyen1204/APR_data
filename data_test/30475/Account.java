import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private ArrayList<Transaction> listTransaction = new ArrayList<Transaction>();
    
    private void deposit(double amount){
        if (amount > 0) this.balance += amount; else 
                System.out.println(" So tien ban nap vao khong hop le!");
    }
    
    private void withdraw(double amount){
        if (this.balance < amount) 
            System.out.println("So tien ban rut vuot qua so du!");
        else if (amount > 0 && amount < this.balance) 
            this.balance -= amount;
        else System.out.println("So tien ban rut ra khong hop le!");
    }
    
    public void addTransaction(double amount, String operation){     
                
      if (operation.equals(Transaction.DEPOSIT)) {
          deposit(amount);
          Transaction transaction = new Transaction(operation, amount, this.balance);
          listTransaction.add(transaction);
      } else if (operation.equals(Transaction.WITHDRAW)) {
          withdraw(amount);
          Transaction transaction = new Transaction(operation, amount, this.balance);
          listTransaction.add(transaction);
      } else {
          System.out.println("Yeu cau khong hop le!");
      }
    }
    
    
    public void printTransaction() {
        for (int i = 0; i < listTransaction.size(); i++) {
            String result = null;
            if (listTransaction.get(i).getOperation().equals(Transaction.DEPOSIT))
                result = "Giao dich " + String.valueOf(i+1) + ": Nap tien $" + String.format("%.2f", listTransaction.get(i).getAmount())+ ". So du luc nay: $" + String.format("%.2f", listTransaction.get(i).getBalance()) + "."; 
            else 
                result = "Giao dich " + String.valueOf(i+1) + ": Rut tien $" + String.format("%.2f",listTransaction.get(i).getAmount()) + ". So du luc nay: $"+ String.format("%.2f", listTransaction.get(i).getBalance()) + ".";
        
        System.out.println(result);
        }
    }
}
