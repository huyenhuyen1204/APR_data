/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package transaction;

/**
 *
 * @author CCNE
 */
public class Transaction {

   private String operation;
   private double amount;
   private double balance;
   public static final String DEPOSIT ="DEPOSIT";
   public static final String WITHDRAW ="WIDTHDRAW";
    
    public Transaction(String operation,double amount, double balance)
    {
        this.operation=operation;
        this.amount=amount;
        this.balance=balance;
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
    public String getDeposit() {
        return this.DEPOSIT;
    }
    public String getWidthdraw() {
        return WITHDRAW;
    }
   
}
