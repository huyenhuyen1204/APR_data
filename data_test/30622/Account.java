import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account(){
        this.transitionList = new ArrayList<Transaction>();
    };

    private void deposit(double amount){
        if(amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else
        {
            this.balance += amount;
        }
    }
    private void withdraw(double amount){
        if(amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if(amount >= this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else
        {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation){
        if(operation.compareTo("deposit") == 0 ){
            deposit(amount);
            this.transitionList.add(new Transaction("deposit", amount, this.balance));

        }
        else if(operation.compareTo("withdraw") == 0) {
            withdraw(amount);
            this.transitionList.add(new Transaction("withdraw", amount, this.balance));
        }
        else
            System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction(){
        int dem = 0;
        if(this.transitionList.isEmpty()) return;
        else {
            DecimalFormat df = new DecimalFormat("#.00");
            for (Transaction i : this.transitionList) {
                dem++;
                if (i.getOperation().compareTo("deposit") == 0)
                {
                    System.out.println("Giao dich " + dem + ": Nap tien $" +df.format( Math.round(i.getAmount()* 100.00)/100.0) + ". So du luc nay: $" + df.format(Math.round(i.getBalance()* 100.0)/100.0) + ".");
                }
                else if (i.getOperation().compareTo("withdraw") == 0){
                    System.out.println("Giao dich " + dem + ": Rut tien $" + df.format(Math.round(i.getAmount()* 100.00)/100.00 )+ ". So du luc nay: $" +df.format( Math.round(i.getBalance()* 100.0)/100.0) + ".");
                }
            }
        }
    }

    public static void main(String args[]){
        Account acc= new Account();
        acc.addTransaction(2000.26,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
