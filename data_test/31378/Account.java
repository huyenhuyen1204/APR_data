
import java.util.ArrayList;


public class Account {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();
    private int countTransaction = 0;

    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }else {
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount,balance);
            transitionList.add(transaction);
            countTransaction ++;
            transaction.setBalance(balance + amount);
            this.setBalance(balance + amount);
        }
    }

    private void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }else if(amount <= 0){
            System.out.println("So tien ban rut khong hop le!");
        }else {
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount,balance);
            transitionList.add(transaction);
            countTransaction ++;
            transaction.setBalance(balance - amount);
            this.setBalance(balance - amount);
        }
    }

    public void addTransaction(double amount, String operation) {
        if(operation == "deposit") {
            deposit(amount);
        }else if(operation == "withdraw") {
            withdraw(amount);
        }else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for(int i=0 ; i<countTransaction ; i++) {
            int j=i+1;
            if(transitionList.get(i).getOperation() == "deposit") {
                System.out.println("Giao dich " + j + transitionList.get(i).depositToString());
            }else {
                System.out.println("Giao dich " + j + transitionList.get(i).withdrawToString());
            }
        }
    }

}
