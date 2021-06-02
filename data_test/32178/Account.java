import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<String> transactionList = new ArrayList<>();

    private void deposit(){

    }
    private void withdraw(){

    }
    private void deposit(double amount){
        if(amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            balance += amount;
        }
    }
    private void withdraw(double amount){
        if(amount <= 0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else{
            balance -= amount;
        }
    }
    public void addTransaction(double amount,String operation){
        if(operation.equals(Transaction.DEPOSIT) == false && operation.equals(Transaction.WITHDRAW) == false){
            System.out.println("Yeu cau khong hop le!");
        }
        else if(operation.equals(Transaction.DEPOSIT)){
            deposit(amount);
            transactionList.add("Giao dich " + (transactionList.size()+1) + ": Nap tien $" + (double)Math.round(amount*100)/100 + ". So du luc nay: $" + (double)Math.round(balance*100)/100 + ".");
        }
        else if(operation.equals(Transaction.WITHDRAW)){
            withdraw(amount);
            transactionList.add("Giao dich " + (transactionList.size()+1) + ": Rut tien $" + (double)Math.round(amount*100)/100 + ". So du luc nay: $" + (double)Math.round(balance*100)/100 + ".");
        }
    }
    public void printTransaction(){
        for(String key : transactionList){
            System.out.println(key);
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
