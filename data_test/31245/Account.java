import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account  {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transitionList.add(new Transaction("Deposit", amount, balance));
        }
    }
    private void withdraw(double amount){
        if (amount<=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount>balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        if (amount>0 && amount<balance) {
            balance-=amount;
            transitionList.add(new Transaction("Withdraw", amount, balance));
        }
    }
    public void addTransaction(double amount, String operation){
        if (operation == "Deposit"){
            deposit(amount);
        }
        else if(operation == "Withdraw"){
            withdraw(amount);
        }
        else {
            System.out.println("Yeu cau khong hop le!");
        }
    }
    String pattern = "0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    public void printTransaction(){
        for (int i=1; i<=transitionList.size(); i++){
            if (transitionList.get(i-1).getOperation() == "Deposit"){
                System.out.println("Giao dich "+ i + ": Nap tien $" + decimalFormat.format(transitionList.get(i-1).getAmount()) +
                        ". So du luc nay: $" + decimalFormat.format(transitionList.get(i-1).getBalance()) + ".");
            }
            else if (transitionList.get(i-1).getOperation() == "Withdraw"){
                System.out.println("Giao dich " + i +": Rut tien $" + decimalFormat.format(transitionList.get(i-1).getAmount()) +
                        ". So du luc nay: $" + decimalFormat.format(transitionList.get(i-1).getBalance()) + ".");
            }
        }
    }
}
