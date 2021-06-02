import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();
    private void deposit(double amount){
        if (amount<=0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }
    private void withdraw(double amount){
        if (amount<=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount>balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }
    public void addTransaction(double amount, String operation){
        if (operation == "deposit"){
            balance+=amount;
            transitionList.add(new Transaction("deposit", amount, balance));
        }
        else if(operation == "withdraw"){
            balance-=amount;
            transitionList.add(new Transaction("withdraw", amount, balance));
        }
        else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
    String pattern = "###.##";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    public void printTransaction(){
        for (int i=0; i<transitionList.size()-1; i++){
            if (transitionList.get(i).getOperation() == "deposit"){
            System.out.println("Giao dich "+ i+1 + ": Nap tien $" + decimalFormat.format(transitionList.get(i).getAmount()) +
                    ". So du luc nay: $" + decimalFormat.format(transitionList.get(i).getBalance())+".");
        }
            else if (transitionList.get(i).getOperation() == "withdraw"){
                System.out.println("Giao dich"+ i+1 +": Rut tien $" + decimalFormat.format(transitionList.get(i).getAmount()) +
                        ". So du luc nay: $" + decimalFormat.format(transitionList.get(i).getBalance())+".");
            }
            }
    }
}
