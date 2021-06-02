import java.math.BigDecimal;
import java.util.ArrayList;

public class Account{

    public static double round(double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }


    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    public String s = "";
    private void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
        else System.out.println("So tien ban nap vao khong hop le!");
    }
    private void withdraw(double amount){
        if(amount > 0){
            if(amount <= balance){
                balance -= amount;
            }
            else System.out.println("So tien ban rut vuot qua so du!");
        }
        else System.out.println("So tien ban rut ra khong hop le!");
    }
    public void addTransaction(double amount,String operation){
        if(operation!= Transaction.DEPOSIT && operation!= Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
        }else {
            if (operation == Transaction.DEPOSIT) {
                deposit(amount);
                if (amount > 0) {
                    //s = "Nap tien $" + String.valueOf(Math.round(amount * 100f) / 100.00f) + ". So du luc nay: $" + String.valueOf(Math.round(balance * 100f) / 100f) + ".";
                    transitionList.add(new Transaction(operation,amount,balance));
                }
            } else {
                withdraw(amount);
                if (amount > 0 && amount <= balance) {
                    //s = "Rut tien $" + String.valueOf(Math.round(amount * 100.00) / 100.00) + ". So du luc nay: $" + String.valueOf(Math.round(balance * 100.00) / 100.00) + ".";
                    transitionList.add(new Transaction(operation,amount,balance));
                }
            }
        }
    }
        public void printTransaction(){
            for(int i=0;i<transitionList.size();i++){
                System.out.print("Giao dich "+String.valueOf(i+1)+": ");
                if(transitionList.get(i).getOperation()== Transaction.DEPOSIT){
                    System.out.println("Nap tien $" + round(transitionList.get(i).getAmount(), 2, BigDecimal.ROUND_HALF_UP) + ". So du luc nay: $" + round(transitionList.get(i).getBalance(), 2, BigDecimal.ROUND_HALF_UP) + ".");
                }
                else System.out.println(s = "Rut tien $" + round(transitionList.get(i).getAmount(), 2, BigDecimal.ROUND_HALF_UP)+ ". So du luc nay: $" + round(transitionList.get(i).getBalance(), 2, BigDecimal.ROUND_HALF_UP) + ".");
            }
        }

    }