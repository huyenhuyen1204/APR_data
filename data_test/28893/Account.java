import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList arrayList = new ArrayList();

    private void deposit(double amount) {
        if ( amount  <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
        }
        else {
            balance = balance + amount;
            balance = round(balance);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.print("So tien ban rut ra khong hop le!");
        }else if (balance - amount < 0) {
            System.out.print("So tien ban rut vuot qua so du!");
        }
        else {
            balance = balance - amount;
            balance = round(balance);
        }
    }

    public void addTransaction(double amount, String operation) {
        DecimalFormat df = new DecimalFormat("##.00");
        if (!operation.equals("deposit") && !operation.equals("withdraw")){
            System.out.print("Yeu cau khong hop le!");
        }else if (operation.equals("deposit")) {
            String result;
            amount = round(amount);
            deposit(amount);
            result = "Nap tien $" + df.format(amount) + " . So du luc nay: $" + df.format(balance) + ".";
            arrayList.add(result);
        }else {
            String result;
            withdraw(amount);
            result = "Rut tien $" + df.format(amount) + " . So du luc nay: $" + df.format(balance) + ".";
            arrayList.add(result);
        }
    }

    public void printTransaction() {
        for ( int i = 0; i < arrayList.size(); i++) {
            System.out.println("Giao dich " + (i+1) + ":" + arrayList.get(i));
        }
    }

    /*public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();

    }*/

    private double round(double number) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        number = bd.doubleValue();
        return number ;
    }
}
