import java.io.FileReader;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private void deposit(double amount){
         if(amount<0){
             System.out.println("So tien ban nap vao khong hop le!");
         }
         this.balance += amount;
    }
    private void withdraw(double amount){
        if(amount>0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > this.balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        this.balance-=amount;
    }
    public void addTransaction(double amount, String operation){
        if(!(operation.equals("withdraw") && operation.equals("deposit"))){
            System.out.println("Yeu cau khong hop le!");
        }
        this.transitionList.add(new Transaction(operation, amount, balance));

    }
    public void printTransaction(){
        for(int i=0; i < transitionList.size(); i++){
            if(transitionList.get(i).getOperation() == "deposit"){
                System.out.println("Giao dich "  + i + ": Nap tien $" + (double)Math.floor(transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" +  (double)Math.floor(transitionList.get(i).getBalance()*100)/100+".");
            }
            else if(transitionList.get(i).getOperation() == "withdraw"){
                System.out.println("Giao dich " + i + ": Rut tien $" + (double)Math.floor(transitionList.get(i).getAmount()*100)/100 + ". So du luc nay: $" +  (double)Math.floor(transitionList.get(i).getBalance()*100)/100 +".");
            }
        }
    }
    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
