import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Account {
    DecimalFormat df = new DecimalFormat("#.00");
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
       this.balance  = this.balance + amount;
    }

    private void withdraw(double amount) {

        this.balance = this.balance - amount;

    }

     public void addTransaction(double amount, String operion){
        Transaction tr = new Transaction(operion,amount);
        transactions.add(tr);
     }

    public void printTransaction() {
        for(int i = 0; i<transactions.size(); i++){
            if(transactions.get(i).getOperation().equals("deposit")){
                if(transactions.get(i).getAmount()<=0){
                    System.out.println("So tien ban nap vao khong hop le!");
                }
                else{
                    deposit(transactions.get(i).getAmount());
                    System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + df.format(transactions.get(i).getAmount()) + ". So du luc nay: $" + df.format(this.balance) + ".");
                }
            }
            else if(transactions.get(i).getOperation().equals("withdraw")) {
                if (transactions.get(i).getAmount() <= 0) {
                    System.out.println("So tien ban rut ra khong hop le!");
                }
                else if(transactions.get(i).getAmount()>this.balance){
                    System.out.println("So tien ban rut vuot qua so du!");
                }
                else {
                    withdraw(transactions.get(i).getAmount());
                    System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + df.format(transactions.get(i).getAmount()) + ". So du luc nay: $" + df.format(this.balance) + ".");
                }
            }
            else {
                System.out.println("Yeu cau khong hop le!");
            }
        }
    }
}
