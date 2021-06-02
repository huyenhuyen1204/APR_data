import java.util.ArrayList;

public class Account {
   
   private double balance;
   ArrayList<Transaction> transactions;

   public Account() {
      transactions = new ArrayList<>();
      balance = 0;
   }

   /**
    * nap tien.
    * @param amount so tien muon nap.
    */
   private void deposit(double amount) {
      if (amount <= 0) {
         System.out.println("So tien ban nap vao khong hop le!");
         return;
      }
      balance += amount;
      transactions.add(new Transaction("deposit", amount, balance));
   }

   /**
    * rut tien.
    */
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
      transactions.add(new Transaction("withdraw", amount, balance));
   }

   /**
    * c.
    */
   public void addTransaction(double amount, String operator) {
      if (operator.equals(Transaction.DEPOSIT)) {
         System.out.println("deposit");
         deposit(amount);
      } else if (operator.equals(Transaction.WITHDRAW)) {
         System.out.println("withdraw");
         withdraw(amount);
      } else {
         System.out.println("Yeu cau khong hop le!");
      }
   }

   /**
    * c.
    */
   public void printTransaction() {
      String format = "Giao dich %d: %s $%.2f. So du luc nay: $%.2f";
      String operator;
      for (int i = 0; i < transactions.size(); i++) {
         Transaction t = transactions.get(i);
         if (t.getOperation().equals("deposit")) {
            operator = "Nap tien";
         } else {
            operator = "Rut tien";
         }
         System.out.println(String.format(format,i + 1, operator, t.getAmount(), t.getBalance()));
      }
   }
}
