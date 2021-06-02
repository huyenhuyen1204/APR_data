import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    private void deposit(double amount) {
        if (amount > 0) {
            this.setBalance(amount);
        } else {
            System.out.print("So tien ban nap vao khong hop le!\n");
        }
    }

    /**
     * fromdoananhwithluv.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.print("So tien ban rut ra khong hop le!\n");
        } else if (amount > this.getBalance()) {
            System.out.print("So tien ban rut vuot qua so du!\n");
        } else {
            this.setBalance(-amount);
        }
    }

    /**
     * fromdoananhwithluv.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            this.deposit(amount);
            Transaction tran = new Transaction(operation, amount, this.getBalance());
            transitionList.add(tran);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            this.withdraw(amount);
            Transaction tran = new Transaction(operation, amount, this.getBalance());
            transitionList.add(tran);
        } else {
            System.out.print("Yeu cau khong hop le!\n");
        }
    }

    public double round(double a) {
        return Math.round(a * 100.0) / 100.0;
    }

    /**
     * fromdoananhwithluv.
     */
    public void printTransaction() {
        int i = 1;
        String operation = "";
        for (Transaction tran : transitionList) {
            if (tran.getOperation().equals(Transaction.WITHDRAW)) {
                operation = "Rut tien $";
            } else {
                operation = "Nap tien $";
            }
            System.out.printf("Giao dich %d: %s%.2f. So du luc nay: $%.2f.%n",
                    i, operation, tran.getAmount(), tran.getBalance());
            i++;
        }
    }


}
