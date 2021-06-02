import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance = 0;
    List<Transaction> list = new ArrayList<>();
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
        if(operation.equals(Transaction.DEPOSIT) && operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        }
        else{
            if(operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            }
            else if(operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
            }
            list.add(new Transaction(operation, amount, balance));
        }
    }
    public void printTransaction() {
        for(int i = 0; i < list.size(); i++) {
            int count = i + 1;
            String pay;
            if(list.get(i).getOperation().equals("deposit")) pay = "Nap tien";
            else pay = "Rut tien";
            System.out.print("Giao dich " + count + ": " + pay + " $");
            System.out.format("%.2f", list.get(i).getAmount());
            System.out.print(". So du luc nay: $");
            System.out.format("%.2f", list.get(i).getBalance());
            System.out.println(".");
        }
    }

}
