import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<String> transactionList = new ArrayList<>();
    private String deposit(){
        return "";
    }
    private String withdraw(){
        return "";
    }
    private void deposit(double amount){
        amount =(double) Math.round(amount*100) / 100;
        if(amount > 0){
            balance += amount;
        }
        else System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount){
        
        amount =(double) Math.round(amount*100) / 100;
        if(amount > 0){
            if(amount > balance){
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }
    public void addTransaction(double amount , String operation){

        String s = "";
        switch (operation){
            case Transaction.DEPOSIT:
                deposit(amount);
                s += "Nap tien $";
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                s+= "Rut tien $";
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }

        s += amount+". So du luc nay: $"+balance;
        transactionList.add(s);

    }
    public void printTransaction(){
        for(int i = 0 ; i < transactionList.size() ; i++){
            System.out.println("Giao dich "+(i+1)+": "+transactionList.get(i) +".");
        }
    }
}
