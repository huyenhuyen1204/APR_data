import java.util.ArrayList;

public class Account {
    private double balance;
    private double deposit;
    private double withdraw;
    private ArrayList<Transaction> transitionList;

    public Account() {
        this.balance = 0;
        this.transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.print("so tien ban nap vao khong hop le!");
        }
        else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.print("so tien ban rut ra khong hop le!");
        }
        else if (amount > this.balance) {
            System.out.print("so tien ban rut vuot qua so du!");
        }
        else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            this.transitionList.add(new Transaction(operation, amount, this.balance));
        }
        else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            this.transitionList.add(new Transaction(operation, amount, this.balance));
        }
        else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String s;
            Transaction temp = transitionList.get(i);
            if (temp.getOperation().equals(Transaction.DEPOSIT)) {
                s = " Nap tien $";
            } else {
                s = " Rut tien $";
            }

            double a = (double) Math.round(temp.getAmount() * 100) / 100;
            double b = (double) Math.round(temp.getBalance() * 100) / 100;
            System.out.printf("Giao dich %d:%s%.2f. So du luc nay: $%.2f.\n",(i+1),s,a,b);
        }
    }
}
