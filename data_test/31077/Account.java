import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account{
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
                    transitionList.add(new Transaction(operation,amount,balance));
                }
            } else {
                withdraw(amount);
                if (amount > 0 && amount <= balance) {
                    transitionList.add(new Transaction(operation,amount,balance));
                }
            }
        }
    }
        public void printTransaction() {
            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < transitionList.size(); i++) {
                System.out.print("Giao dich " + String.valueOf(i + 1) + ": ");
                if (transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                    System.out.println("Nap tien $" + df.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + df.format(transitionList.get(i).getBalance()) + ".");
                } else
                    System.out.println(s = "Rut tien $" + df.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + df.format(transitionList.get(i).getBalance()) + ".");
            }
        }
    }