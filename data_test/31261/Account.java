import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount) {
        if (amount < 0) System.out.println("So tien ban nap vao khong hop le!");
        else this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount < 0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > this.balance) System.out.println("So tien ban rut vuot qua so du!");
        else this.balance -= amount;
    }

    public void addTransaction(double amount , String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
            Transaction newtransaction = new Transaction("deposit" , amount , this.balance);
            transitionList.add(newtransaction);
        }
        else if (operation.equals("withdraw")) {
            withdraw(amount);
            Transaction newtransaction = new Transaction("withdraw" , amount , this.balance);
            transitionList.add(newtransaction);
        }
        else System.out.println("Yeu cau khong hop le!");
    }
    public void printTransaction() {
        for(int i = 0 ; i < transitionList.size() ; i++) {
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i).printaTransaction());
        }
    }
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
