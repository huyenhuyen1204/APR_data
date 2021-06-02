import java.util.ArrayList;

public class Account{
    private double balance = 0;
    private ArrayList<String> list = new ArrayList<>();
    public String s = "";
    private void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
        else System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount){
        if(amount > 0){
            if(amount <= balance){
                balance -= amount;
            }
            else System.out.println("So tien ban rut vuot qua so du!");
        }
        else System.out.println("So tien ban rut ra khong hop le!");
    }
    public void addTransaction(double amount,String operation){
        if(operation!= Transaction.DEPOSIT && operation!= Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
        }
        if (operation == Transaction.DEPOSIT) {
            deposit(amount);
            if (amount > 0) {
                s = "Nap tien $" + String.valueOf(Math.round(amount * 100.0) / 100.0) + ". So du luc nay: $" + String.valueOf(Math.round(balance * 100.0) / 100.0) + ".";
                list.add(s);
            }
        }
        else{
            withdraw(amount);
            if(amount > 0 && amount <= balance){
                s = "Rut tien $"+String.valueOf(Math.round(amount*100.0)/100.0)+". So du luc nay: $"+String.valueOf(Math.round(balance*100.0)/100.0)+".";
                list.add(s);
            }
        }
    }
        public void printTransaction(){
            for(int i=0;i<list.size();i++){
                System.out.println("Giao dich "+String.valueOf(i+1)+": "+list.get(i));
            }
        }

    }