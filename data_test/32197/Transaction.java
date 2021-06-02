public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public Transaction(double amount, double balance, String operation)
    {
        this.balance = balance;
        this.operation = operation;
        this.amount = amount;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void print()
    {
        if(operation == Transaction.DEPOSIT)
        {
            System.out.printf("Nap tien $%.2f. So du luc nay: $%.2f.\n", this.amount, this.balance);
        }
        else if(operation == Transaction.WITHDRAW)
        {
            System.out.printf("Rut tien $%.2f. So du luc nay: $%.2f.\n", this.amount, this.balance);
        }
    }
}
