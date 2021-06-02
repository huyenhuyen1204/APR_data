import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance=0;
    private ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
    private void deposit(double amount){
        if(amount<=0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance+=amount;
    }
    private void widthdraw(double amount){
        if(amount<=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if (amount>this.balance){
                System.out.println("So tien ban rut ra khong hop le!");
            }
        else {
            this.balance-=amount;
        }
    }
    public void addTransaction(double amount , String operation){
        if(!(operation.equals("deposit")
                || operation.equals("withdraw"))){
            System.out.println("Yeu cau khong hop le!");
        }
        else {
            if(operation.equals("deposit")){
                deposit(amount);
                transactionList.add(new Transaction(operation,amount,balance));
            }
            else if(operation.equals("withdraw")){
                widthdraw(amount);
                transactionList.add(new Transaction(operation,amount,balance));
            }

        }

    }
    public void printTransaction(){
        int i=1;
        for (int j=0;j<transactionList.size();j++){
            StringBuilder str= new StringBuilder("");
            str.append("Giao dich ").append(i).append(": ");
            if(transactionList.get(j).getOperation().equals("deposit")){
                str.append("Nap tien $");
            }
            else {
                str.append("Rut tien $");
            }
            str.append(dcf.format(transactionList.get(j).getAmount()));
            str.append(". So du luc nay: $");
            str.append(dcf.format(transactionList.get(j).getBalance()));
            str.append(".");
            System.out.println(str.toString());
            i++;
        }
    }
    DecimalFormat dcf = new DecimalFormat("#.00");
//    public static void main(String[] args) {
//        Account acc= new Account();
//        acc.addTransaction(2000.255,"deposit");
//        acc.addTransaction(1000,"withdraw");
//        acc.printTransaction();
//    }
}
