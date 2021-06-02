//package src;

import java.util.ArrayList;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {
    private double balance;
    ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount){
        if(amount <= 0) System.out.print("So tein ban nap vao khong hop le!");
        else{
            this.balance += amount;
        }
    }

    private void withdraw(double amount){
        if(amount <= 0) System.out.print("So tein ban rut ra khong hop le!");
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
            if(this.transitionList.get(i).getOperation() == "withdraw"){
                System.out.println("Giao dich " + i+1 + ": Rut tien $" + Math.round(this.transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" + Math.round(this.transitionList.get(i).getBalance() * 100)/100 + ".");
            }else{
                System.out.println("Giao dich " + i+1 + ": Nap tien $" + Math.round(this.transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" + Math.round(this.transitionList.get(i).getBalance() * 100)/100 + ".");
            }
        }
    }

}
