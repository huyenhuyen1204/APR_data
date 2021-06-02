
import java.util.ArrayList;


public class Account {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    private int countTransaction = 0;

    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }else {
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount,balance);
            transactionList.add(transaction);
            countTransaction ++;
            transaction.setBalance(balance + amount);
            this.setBalance(balance + amount);
        }
    }

    private void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("So tien ban rut ra khong hop le!");
        }else {
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount,balance);
            transactionList.add(transaction);
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
            if(transactionList.get(i).getOperation() == "deposit") {
                System.out.println("Giao dich " + j + transactionList.get(i).depositToString());
            }else {
                System.out.println("Giao dich " + j + transactionList.get(i).withdrawToString());
            }
        }
    }

}
