import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        Transaction a = new Transaction(operation, amount, balance);
        if (operation == a.getDeposit()) {
            deposit(amount);
        } else if (operation == a.getWithdraw()) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
        a.setBalance(balance);
        transitionList.add(a);
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.println("Giao dich " + (i+1) + ": Nap tien $" + (double)Math.round(transitionList.get(i).getAmount() * 100)/100 + ". So du luc nay: $" + (double)Math.round(transitionList.get(i).getBalance() * 100) / 100 + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
