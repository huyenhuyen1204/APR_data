import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;
    List<Transaction> List = new ArrayList<>();
    private void deposit (double amount) {
        if(amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else balance += amount;
    }
    private void withdraw(double amount) {
        if(amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else {
            balance -= amount;
        }
    }
    public void addTransaction(double amount, String operation) {
        if(operation.equals("deposit") && operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        }
        else{
            if(operation.equals("deposit")) {
                deposit(amount);
            }
            else if(operation.equals("withdraw")) {
                withdraw(amount);
            }
            List.add(new Transaction(operation, amount, balance));
        }
    }
    public void printTransaction() {
        for(int i = 0; i < List.size(); i++) {
            int count = i + 1;
            double a = (double) Math.round(List.get(i).getAmount() * 100) / 100;
            double b = (double) Math.round(List.get(i).getBalance() * 100) / 100;
            System.out.println("Giao dich " + count + ": Nap tien $" + a + ". So du luc nay: $" + b + "." );
        }
    }

}
