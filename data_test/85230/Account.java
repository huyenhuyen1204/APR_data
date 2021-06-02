import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;

        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {

        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }

    }

    /**
     * comment.
     */

    public void addTransaction(double amount, String operation) {
        if (Transaction.DEPOSIT == operation) {
            this.deposit(amount);
            Transaction tr = new Transaction("Nap tien", amount, this.balance);
            transitionList.add(tr);
        } else if (Transaction.WITHDRAW == operation) {
            this.withdraw(amount);
            Transaction tr = new Transaction("Rut tien", amount, this.balance);
            transitionList.add(tr);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * comment.
     */

    public void  printTransaction() {
        int i = 1;
        for (Transaction item : transitionList) {
            System.out.printf("Giao dich " + i +  ": " + item.getOperation()
                    + " $%.2f. So du luc nay: $%.2f.\n", item.getAmount(), item.getBalance());
            i++;
        }
    }




}
 