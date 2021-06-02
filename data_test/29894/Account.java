import java.util.ArrayList;

/**
 * Created by CCNE on 29/10/2019.
 */
public class Account {
    private double balance;
    ArrayList list = new ArrayList();
    private void deposit(double amount){
        if (amount<=0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }
    private void withdraw(double amount){
        if (amount<=0){
            System.out.println("So tien ban rut ra khong hop le1");
        }
        if (amount>balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }
    public void addTransaction(double amount, String operation){
        if ((operation != "deposit") || (operation !="withdraw")){
            System.out.println("Yeu cau khong hop le!");
        }
        if (operation == "deposit"){
            balance+=amount;
        }
        else if(operation == "withdraw"){
            balance-=amount;
        }
    }
    public void printTransaction(){

    }
}
