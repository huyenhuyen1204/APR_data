import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> transitionList = new ArrayList();

    private void deposit(double amount){
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else balance += amount;
    }

    private void withdraw (double amount){
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance) System.out.println("So tien ban rut vuot qua so du!");
        else balance -= amount;
    }

    public void addTransaction(double amount, String operation){
        if( !operation.equals("deposit") && !operation.equals("withdraw"))
            System.out.println("Yeu cau khong hop le!");
        else if(operation.equals("deposit")){
            deposit(amount);
            if(amount >= 0)
                transitionList.add("Nap tien $" + (double) Math.round(amount*100)/100 + ". So du luc nay: $" + (double) Math.round(balance*100)/100);

        }
        else {
            withdraw(amount);
            if(amount > 0 && amount <= balance)
                transitionList.add("Rut tien $" + (double) Math.round(amount*100)/100 + ". So du luc nay: $" + (double) Math.round(balance*100)/100);
        }
    }

    public void printTransaction(){
        for(int i = 0; i < transitionList.size(); i++){
            System.out.println(transitionList.get(i));
        }
    }
}
