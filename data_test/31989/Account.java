

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;
    private List<Transaction> transactions = new ArrayList<>();
    private void deposit(double amount){
        if(amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    public Account() {
    }

    private void withdraw(double amount){
        if(amount > 0) {
            if(this.balance >= amount) {
                this.balance -= amount;
            } else {
                System.out.println("So tien ban rut vuot qua so du!");
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }
    public void addTransaction(double amount, String operation){
        if(operation.equals(Transaction.DEPOSIT)){
            transactions.add(new Transaction(operation,amount,this.balance));
            deposit(amount);
        } else if(operation.equals(Transaction.WITHDRAW)){
            transactions.add(new Transaction(operation,amount,this.balance));
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
    public void printTransaction(){
        int i = 0;
        String m;
        while(!transactions.isEmpty()){
            double k = Math.round(transactions.get(i).getAmount() * 100.0) / 100.0;
            if(transactions.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                double b = Math.round((transactions.get(i).getBalance() + k) * 100.0) / 100.0;
                System.out.println("Giao dich " + (i + 1) + ": Nap tien " + k + ". So du luc nay: " + b);
            } else if(transactions.get(i).getOperation().equals(Transaction.WITHDRAW)){
                double b = Math.round((transactions.get(i).getBalance() - k) * 100.0) / 100.0;
                System.out.println("Giao dich " + (i + 1) + ": Rut tien " + k + ". So du luc nay: " + b);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
