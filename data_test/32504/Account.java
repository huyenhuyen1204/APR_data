import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList();

    private void deposit(double amount){
        if(amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else balance += amount;
    }

    private void withdraw (double amount){
        if(amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance) System.out.println("So tien ban rut vuot qua so du!");
        else balance -= amount;
    }

    public void addTransaction(double amount, String operation){
        if( !operation.equals("deposit") && !operation.equals("withdraw"))
            System.out.println("Yeu cau khong hop le!");
        else if(operation.equals("deposit")){
            deposit(amount);
            if(amount >= 0)
                transitionList.add(new Transaction(operation, amount, balance));
        }
        else {
            withdraw(amount);
            if(amount > 0 && amount <= balance)
                transitionList.add(new Transaction(operation, amount, balance));
        }
    }

    public void printTransaction(){
        for(int i = 0; i < transitionList.size(); i++){
            if(transitionList.get(i).getOperation().equals("deposit")) transitionList.get(i).setOperation("Nap tien");
            else if(transitionList.get(i).getOperation().equals("withdraw")) transitionList.get(i).setOperation("Rut tien");
            DecimalFormat df = new DecimalFormat("#.00");
            double Amount = transitionList.get(i).getAmount();
            double Balance = transitionList.get(i).getBalance();

            System.out.println("Giao dich " + (i+1) + ": " + transitionList.get(i).getOperation() + " $" + df.format(Amount) + ". So du luc nay: $" + df.format(Balance) + ".");
        }
    }
}
