import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList <Transaction> transitionList;

    public Account () {
        this.balance = 0;
        transitionList = new ArrayList<Transaction>();
    }

    private void deposit (double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else System.out.println("So tien ban nap vao khong hop le!");
    }

    private void withdraw (double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else if (amount > this.balance) {
            System.out.println(" So tien ban rut vuot qua so du!");
        }
        else System.out.println("So tien ban rut ra khong hop le!");
    }

    public void addTransaction ( double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, this.balance));
        } else System.out.println("Yeu cau khong hop le!");
    }

    public double getRound(double x) {
        return (double) Math.round(x*100)/100 ;
    }

    public void printTransaction() {
        if (!transitionList.isEmpty()) {
            for (int i = 0 ; i < transitionList.size(); i++) {
                int num = i+1;
                if (transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                    System.out.println("Giao dich " + num + ": Nap tien $" + getRound(transitionList.get(i).getAmount()) +
                            ". So du luc nay: $" + getRound(transitionList.get(i).getBalance()) + ".");
                }
                else {
                    System.out.println("Giao dich " + num + ": Rut tien $" + getRound(transitionList.get(i).getAmount()) +
                            ". So du luc nay: $" + getRound(transitionList.get(i).getBalance()) + ".");
                }
            }
        }
    }



}
