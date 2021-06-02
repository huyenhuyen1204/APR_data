import java.util.ArrayList;

public class Account extends Transaction {
    private double balance;
    private  ArrayList transitionList= new ArrayList();
    public Account(){};
    private void deposit(double amount){
        if (amount>0) {
            balance += amount;
            //System.out.println(balance);
        }
        else System.out.println("So tien ban nap vao khong hop le!");

    }
    private void withdraw(double amount){
        if  (amount>0&&amount<=balance) {
            balance -= amount;
           // System.out.println(balance);
        }
        else if (amount<=0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if  (amount>balance)
            System.out.println("So tien ban rut vuot qua so du!");

    }
    public void addTransaction(double amount , String operation){
        String res="";
            if (operation==DEPOSIT) {
                deposit(amount);
                res+=" Nap tien $"+(double)Math.round(amount*100)/100+". So du luc nay: $"+(double)Math.round(balance*100)/100+".";
                transitionList.add(res);

            }
            else if  (operation==WITHDRAW) {
                withdraw(amount);
                res+=" Rut tien $"+(double)Math.round(amount*100)/100+". So du luc nay: $"+(double)Math.round(balance*100)/100+".";
               transitionList.add(res);
            }
            else {
                res += "Yeu cau khong hop le!";
                transitionList.add(res);
            }

    }
    public void printTransaction(){
        for (int i=0;i<transitionList.size();i++){
            System.out.println("Giao dich "+(i+1)+":"+transitionList.get(i));
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
