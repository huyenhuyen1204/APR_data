//package src;

import java.util.ArrayList;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount){
        if(amount <= 0) System.out.print("So tien ban nap vao khong hop le!");
        else this.balance += amount;
    }

    private void withdraw(double amount){
        if(amount <= 0) System.out.print("So tien ban rut ra khong hop le!");
        else if(amount > this.balance) System.out.print("So tien ban rut vuot qua so du!");
        else this.balance -= amount;
    }

    public void addTransaction(double amount, String operation){
        if(operation != "withdraw" && operation != "deposit"){
            System.out.print("Yeu cau khong hop le!");
        }else {
            if (operation == "withdraw") {
                this.withdraw(amount);
                this.transitionList.add(new Transaction(operation, amount, this.balance));
            } else {
                this.deposit(amount);
                this.transitionList.add(new Transaction(operation, amount, this.balance));
            }
        }
    }

    public void printTransaction(){
        for(int i = 0; i < this.transitionList.size(); i++){
            int index = i + 1;
            if(this.transitionList.get(i).getOperation() == "withdraw"){
                System.out.println("Giao dich " + index + ": Rut tien $" + Math.floor(this.transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" + Math.floor(this.transitionList.get(i).getBalance() * 100)/100 + ".");
            }else{
                System.out.println("Giao dich " + index + ": Nap tien $" + Math.floor(this.transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" + Math.floor(this.transitionList.get(i).getBalance() * 100)/100 + ".");
            }
        }
    }

}
