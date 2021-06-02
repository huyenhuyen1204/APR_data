import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Account {
    DecimalFormat df = new DecimalFormat("#.00");
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
       if(amount<=0){
           System.out.println("So tien ban nap vao khong hop le!");
       }
       else{
           this.balance = this.balance + amount;
       }
    }

    private void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount>this.balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else {
           this.balance= this.balance - amount;
        }

    }

     public void addTransaction(double amount, String operion){
        if(operion!="deposit" && operion!="withdraw"){
            System.out.println("Yeu cau khong hop le!");
        }
        else{
            Transaction tr = new Transaction(operion,amount,this.balance);
            if(tr.getOperation().equals("deposit")){
                deposit(tr.getAmount());

                if(tr.getAmount()>0){
                    Transaction tr1 = new Transaction(operion,amount,this.balance);
                    transitionList.add(tr1);
                }
            }
            if(tr.getOperation().equals("withdraw")){
                withdraw(tr.getAmount());
                if(tr.getAmount()>0 && tr.getAmount()<=this.balance){
                    Transaction tr1 = new Transaction(operion,amount,this.balance);
                    transitionList.add(tr1);
                }

            }

        }
     }


    public void printTransaction() {
        for(int i = 0; i<transitionList.size(); i++){
            if(transitionList.get(i).getOperation().equals("deposit")){

                System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + df.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + df.format(transitionList.get(i).getBalance()) + ".");

            }
            else if(transitionList.get(i).getOperation().equals("withdraw")) {

                    System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + df.format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + df.format(transitionList.get(i).getBalance()) + ".");
            }

        }
    }
}
