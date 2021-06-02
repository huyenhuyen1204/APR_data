

import java.util.ArrayList;
import java.util.List;


public class Account{
    private double balance = 0;
    List<Transaction> transactionList = new ArrayList<Transaction>();
    private void deposit(double amount){
        if(amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else{
            balance += amount;
        }
    }
    private void withdraw(double amount){
        if(amount <= 0){
            System.out.println("So tien ban rut ta khong hop le!");
        }
        else if(amount > balance){
            System.out.println("So tien ban rut ra vuot qua so du!");
        }
        else
            balance -= amount;
    }
    public void addTransaction(double amount, String operation){
        if(operation != "deposit" && operation != "withdraw" ){
            System.out.println("Yeu cau khong hop le!");
        }
        else if(operation == "deposit"){
            deposit(amount);
            transactionList.add(new Transaction(operation,amount,balance));
        }
        else if(operation == "withdraw"){
            withdraw(amount);
            transactionList.add(new Transaction(operation,amount,balance));
        }
    }
    public void printTransaction(){
        for(int i=0;i<transactionList.size();i++){
            if(transactionList.get(i).getOperation().equals("deposit"))
                System.out.format("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",i+1,transactionList.get(i).getAmount(),transactionList.get(i).getBalance());
            else
                System.out.format("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",i+1,transactionList.get(i).getAmount(),transactionList.get(i).getBalance());
        }
    }
    public static void main(String[] args){
        Account acc = new Account();
        acc.addTransaction(2000,"deposit");
        acc.addTransaction(2000,"deposit");
        acc.addTransaction(1500,"withdraw");
        acc.addTransaction(5000,"withdraw");
        acc.printTransaction();
    }
}