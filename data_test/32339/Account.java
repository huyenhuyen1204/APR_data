import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionsList = new ArrayList<Transaction>();

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            balance += amount;
        }
    }

    public void withdraw(double amount){
        if(amount <=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else{
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation){
        if(operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW)
        {
            System.out.println("Yeu cau khong hop le!");
        }
        else if(operation == Transaction.DEPOSIT){
            this.deposit(amount);
        }
        else if(operation == Transaction.WITHDRAW)
        {
            this.withdraw(amount);
        }
    }

    public void printTransaction(){
    }
}
