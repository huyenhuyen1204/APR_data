
import java.util.ArrayList;

public class Account {

    private double balance = 0;

    private ArrayList<Transaction> transitionList;

    public Account() {
        transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount >= this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        this.balance = Math.round(getBalance() * 100.0) / 100.0;
        
        for (int i = 0; i < transitionList.size(); i++) {
            double balance1 = Math.round(transitionList.get(i).getBalance() * 100.0) / 100.0;
            double amount1 = Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0;
            
            double balance2 = Math.round(transitionList.get(i).getBalance());
            double amount2 = Math.round(transitionList.get(i).getAmount());
            
            String balance = String.valueOf((balance1 == balance2) ? balance2 + "0" : balance1);
            String amount = String.valueOf((amount1 == amount2) ? amount2 + "0" : amount1);
            
            if(transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)){
                System.out.println("Giao dich " + (i+1) +": Nap tien $" + amount + ". So du luc nay: $" + balance + ".");
            }else if(transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)){
                System.out.println("Giao dich " + (i+1) +": Rut tien $" + amount + ". So du luc nay: $" + balance + ".");
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(3000.68, "deposit");
        acc.addTransaction(3000.00, "deposit");
        acc.addTransaction(1000.00, "withdraw");
        acc.addTransaction(2000.00, "withdraw");
        acc.printTransaction();
    }
}
