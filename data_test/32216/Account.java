/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package transaction;

import java.util.ArrayList;

/**
 *
 * @author CCNE
 */
public class Account 
{
    private double balance;
    private final ArrayList<Transaction> list_tran =new ArrayList<Transaction>();
    private void deposit(double amount)
    {
        if(amount <=0)
        {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else 
        {
            this.balance+=amount;
            list_tran.add(new Transaction(Transaction.DEPOSIT,amount, balance));
        }
    }
    private void withdraw(double amount)
    {
        if(amount<=0)
        {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount> balance )
        {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else 
        {
            this.balance-=amount;
            list_tran.add(new Transaction(Transaction.WITHDRAW,amount, balance));
            
        }
    }
     public void addTransaction(double amount, String operation)
    {
        if(operation==Transaction.DEPOSIT)
        {
            deposit(amount);
        }
        else if(operation==Transaction.WITHDRAW)
        {
            withdraw(amount);
        }
        else System.out.println("Yeu cau khong hop le!");
        
    }

    public void printTransaction()
    {
        int i = 1 ;
        for ( Transaction item : list_tran){
            System.out.printf("Giao dich " + i +  ": "+item.getOperation() + " $%.2f. So du luc nay: $%.2f.\n", item.getAmount(), item.getBalance());
            i++;
        }
    }

    
}
