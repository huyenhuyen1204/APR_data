import java.util.ArrayList;

public class Account {
   private double balance;
   private ArrayList<Transaction> transitionList = new ArrayList();
   private void deposit(double amount){
        if (amount <= 0 ) System.out.println("So tien ban nap vao khong hop le!");
        else {
            balance += amount;
            transitionList.add(new Transaction("deposit", amount, this.balance));
        }
   }
   private void withdraw(double amount){
       if (amount <= 0)
           System.out.println("So tien ban rut ra khong hop le!");
       else if (amount > this.balance)
           System.out.println("So tien ban rut vuot qua so du!");
       else {
           balance -= amount;
           transitionList.add(new Transaction("withdraw",amount,balance));
       }
   }
   public void addTransaction(double amount,String operation){
       if (operation != "deposit" && operation != "withdraw")
           System.out.println("Yeu cau khong hop le!");
       else if (operation == "deposit")
           this.deposit(amount);
       else
           this.withdraw(amount);
   }

   public void printTransaction(){
       for (Transaction transaction : transitionList){
        String t ="";
        if (transaction.getOperation() == "withdraw") t = "Rut tien";
        else t = "Nap tien";
        System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",transitionList.indexOf(transaction)+1,t,transaction.getAmount(),transaction.getBalance());
       }
   }
   Account(double balance){
       this.balance = balance;
   }

    public double getBalance() {
        return balance;
    }
    Account(){

    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
     public static void main(String[] argv){
       Account acc = new Account(30);
       acc.addTransaction(5,"withdraw");
       acc.addTransaction(40,"deposit");
       acc.printTransaction();
   }
}
