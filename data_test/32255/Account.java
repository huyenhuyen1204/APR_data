import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transitionList = new ArrayList<>();

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
            transitionList.add(new Transaction(operation,amount,balance));
        }
        else if(operation.equals(Transaction.WITHDRAW)){
            withdraw(amount);
            transitionList.add(new Transaction(operation,amount,balance));
        }
    }
    public void printTransaction(){
        for(int i=0;i<transitionList.size();i++){
            System.out.print("Giao dich " + (i+1) + ": ");
            if(transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)){
                System.out.printf("Nap tien $%.2f. ", transitionList.get(i).getAmount());
                System.out.printf("So du luc nay: $%.2f.\n", transitionList.get(i).getBalance());
            }
            else{
                System.out.printf("Rut tien $%.2f. ", transitionList.get(i).getAmount());
                System.out.printf("So du luc nay: $%.2f.\n", transitionList.get(i).getBalance());
            }
        }
    }
}