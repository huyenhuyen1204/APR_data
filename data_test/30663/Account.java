import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();
    private void deposit(double amount){
        if(amount<=0) System.out.print("So tien ban nap vao khong hop le!");
        else balance+=amount;
    }
    private void withdraw(double amount){
        if(amount<=0) System.out.print("So tien ban rut ra khong hop le!");
        else if(amount>balance) System.out.print("So tien ban rut vuot qua so du!");
        else balance-=amount;
    }
    public void addTransaction(double amount, String operation){
        if(!operation.equals("withdraw") && !operation.equals("deposit")) System.out.print("Yeu cau khong hop le!");
        else {
            if(operation.equals("deposit")) deposit(amount);
            else if(operation.equals("withdraw")) withdraw(amount);
            Transaction add = new Transaction(operation,amount,balance);
            transitionList.add(add);
        }
    }
    public void  printTransaction() {
        for (int i=0; i<transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",i+1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",i+1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
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
