import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Account {
    private double balance;
    private ArrayList<Transaction> list = new ArrayList<Transaction>();
    private void deposit(double amount){
        if(amount<=0) System.out.print("So tien ban nap vao khong hop le!");
        else balance+=amount;
    }
    private void withdraw(double amount){
        if(amount<=0) System.out.print("So tien ban rut ra khong hop le!");
        else if(amount>balance) System.out.print("So tien ban rut ra vuot qua so du");
        else balance-=amount;
    }
    public void addTransaction(double amount, String operation){
        if(!operation.equals("withdraw") && !operation.equals("deposit")) System.out.print("Yeu cau khong hop le!");
        else {
            if(operation.equals("deposit")) deposit(amount);
            else if(operation.equals("withdraw")) withdraw(amount);
            Transaction add = new Transaction(operation,amount,balance);
            list.add(add);
        }
    }
    void printTransaction(){
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        for (int i=0; i<list.size(); i++){
            String Amount = decimalFormat.format(list.get(i).getAmount());
            String Balance = decimalFormat.format(list.get(i).getBalance());
            if(list.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (i+1) + ": Nap tien $" + Amount + ". So du luc nay: $" + Balance +".");
            } else if(list.get(i).getOperation().equals("withdraw")){
                System.out.println("Giao dich " + (i+1) + ": Rut tien $" + (double)Math.round(list.get(i).getAmount()*1000)/1000 + ". So du luc nay: $" + Balance +".");
            }
        }
    }

    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000.00,"withdraw");
        acc.printTransaction();
    }
}
