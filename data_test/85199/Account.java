import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * khoi tao khong tham so.
     */
    public Account() {
    }

    //setter & getter
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * phuong thuc rut tien tu tai khoan.
     * @param amount so tien rut.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * phuong thuc nap tien vao tai khoan.
     * @param amount so tien giao dich.
     */
    private void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Them mot giao dich moi.
     * @param amount so tien nap vao.
     * @param operation ten giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("withdraw")) {
            this.withdraw(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        } else if (operation.equals("deposit")) {
            this.deposit(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * luu vao lich su giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); ++i) {
            System.out.println("Giao dich " + (i + 1) + ": " + transitionList.get(i).toString());
        }
    }

    /**
     * main.
     * @param args a.
     */
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }

}

