import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> list= new ArrayList<>();

    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += roundAvoid(amount, 2);
        }
    }

    private void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (this.balance - amount < 0) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= roundAvoid(amount, 2);
        }
    }

    public void addTransaction(double amount, String operation) {
        if(! (operation.toUpperCase().compareTo(Transaction.operation1) == 0 ||
        operation.toUpperCase().compareTo(Transaction.operation2) == 0)) {
            System.out.println("Yeu cau khong hop le!");
        } else if(operation.toUpperCase().compareTo(Transaction.operation1) == 0) {
            deposit(amount);
            list.add(new Transaction(operation, roundAvoid(amount, 2), this.balance));
        } else if(operation.toUpperCase().compareTo(Transaction.operation2) == 0) {
            withdraw(amount);
            list.add(new Transaction(operation, roundAvoid(amount, 2), this.balance));
        }
    }

    public void printTransaction() {
        int i = 1;
        for(Transaction trans:list) {
            if(trans.getOperation().toUpperCase().compareTo(Transaction.operation1) == 0) {
                System.out.println("Giao dich " + i + ": Nap tien $" +
                        trans.getAmount() + ". So du luc nay: $" + trans.getBalance() + ".");
            } else {
                System.out.println("Giao dich " + i + ": Rut tien $" +
                        trans.getAmount() + ". So du luc nay: $" + trans.getBalance() + ".");
            }
            i ++;
        }
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
