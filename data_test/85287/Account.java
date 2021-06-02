import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * ham deposit.
     */
    private void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    /**
     * ham withdraw.
     */
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
     * cmt.
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
     * cmt.
     */
    public void printTransaction() {
        int i = 1;
        for (Transaction transaction : transitionList) {
            System.out.printf("Giao dich " + i + ": " + transaction.getOperation()
                            + " $%.2f. So du luc nay: $%.2f.\n",
                    transaction.getAmount(), transaction.getBalance());
            i++;
        }

    }

    /**
     * main.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }


}
