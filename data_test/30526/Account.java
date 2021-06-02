

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    List<Transaction> transactionList = new ArrayList<>();

    private void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if(amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount , String operation) {
        if(!(operation.equals(Transaction.DEPOSIT) || (operation.equals(Transaction.WITHDRAW)))) {
            System.out.println("Yeu cau khong hop le!");
        } else{
            if(operation.equals(Transaction.DEPOSIT))
                deposit(amount);
            else
                withdraw(amount);
            transactionList.add(new Transaction(operation,amount,this.balance));
        }
    }

    public void printTransaction() {
        int i = 0;
        for(Transaction transaction : transactionList) {
            i++;
            System.out.println("Giao dich " + i +transaction.toString());
        }
    }

    public static void main(String[] a) {
        Account myAcc = new Account();
        myAcc.addTransaction(2000.255,"deposit");
        myAcc.addTransaction(1000,"withdraw");
        myAcc.printTransaction();
    }
}
