

import java.text.DecimalFormat;
public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

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

    public static String getDEPOSIT() {
        return DEPOSIT;
    }

    public static String getWITHDRAW() {
        return WITHDRAW;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        if(this.operation.equals(Transaction.DEPOSIT))
            return ": Nap tien $" + df.format(this.amount) + ". So du luc nay: $" + df.format(this.balance) + ".";
        else
            return ": Rut tien $" + df.format(this.amount) + ". So du luc nay: $" + df.format(this.balance) + ".";
    }
}
