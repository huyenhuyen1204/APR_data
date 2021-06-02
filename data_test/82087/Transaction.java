public class Transaction {
   
   private String operation;
   private double amount;
   private double balance;
   public static final String DEPOSIT = "deposit";
   public static final String WITHDRAW = "withdraw";


   /**
    * c.
    * @param operation c.
    * @param amount c.
    * @param balance c.
    */
   public Transaction(String operation, double amount, double balance) {
      this.operation = operation;
      this.amount = amount;
      this.balance = balance;
   }

   /** 
    * c.
   */
   public String getOperation() {
      return this.operation;
   }

   /**
    * c.
    */
   public void setOperation(String operation) {
      this.operation = operation;
   }

   /**
    * c.
    * @return c.
    */
   public double getAmount() {
      return this.amount;
   }

   /**
    * c.
    * @param amount c.
    */
   public void setAmount(double amount) {
      this.amount = amount;
   }

   /**
    * c.
    * @return c.
    */
   public double getBalance() {
      return this.balance;
   }

   /**
    * c.
    * @param balance c.
   */
   public void setBalance(double balance) {
      this.balance = balance;
   }

}
