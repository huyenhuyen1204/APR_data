import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> ds= new ArrayList<>();
    private void deposit(){

    }
    private void withdraw(){

    }
    public void deposit( double amount){
        if(amount<=0) System.out.println("So tien ban nap vao khong hop le");
        else {
            double tien= (double) Math.round(amount*100)/100;
            balance+=tien;
            double sodu=(double) Math.round(balance*100)/100;
            Transaction transaction= new Transaction("deposit", tien, sodu);
            ds.add(transaction);
        }
    }

    public void withdraw(double amount){
        if(amount<=0) System.out.println("So tien ban rut ra khong hop le");
        else if(amount>balance) System.out.println("So tien ban rut vuot qua so du!");
        else{
            double tien= (double) Math.round(amount*100)/100;
            balance-=tien;
            double sodu=(double) Math.round(balance*100)/100;
            Transaction transaction= new Transaction("withdraw", tien, sodu);
            ds.add(transaction);
        }
    }

    public void addTransaction(double amount, String operation){
        if(!operation.equals(Transaction.DEPOSIT)&& !operation.equals(Transaction.WITHDRAW)){
            System.out.println("Yeu cau khong hop le!");
        }
        else if(operation.equals(Transaction.DEPOSIT)){
            deposit(amount);
        }
        else if(operation.equals(Transaction.WITHDRAW)){
            withdraw(amount);
        }
    }

    public void printTransaction(){
        for(int i=0; i<ds.size(); i++){
            System.out.print("Giao dich " + (i+1) + ": ");

            if(ds.get(i).getOperation().equals("deposit")) {
                System.out.println("Nap tien $" + ds.get(i).getAmount()+". So du luc nay: $" + ds.get(i).getBalance()+ "." );
            }
            else{
                System.out.println("Rut tien $" + ds.get(i).getAmount()+". So du luc nay: $" + ds.get(i).getBalance()+ "." );
            }
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
