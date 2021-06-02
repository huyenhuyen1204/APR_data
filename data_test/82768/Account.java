import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        this.balance = 0;
        transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;

    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;


    }

    /**
     * abc.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction trans = new Transaction(Transaction.DEPOSIT, amount, this.balance);
            this.transitionList.add(trans);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction trans = new Transaction(Transaction.WITHDRAW, amount, this.balance);
            this.transitionList.add(trans);
        }


    }

    /**
     * abc.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", i + 1,
                        transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", i + 1,
                        transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            }
        }
    }

//    public static void main(String[] args) {
//        Account acc= new Account();
//        acc.addTransaction(2000.255,"deposit");
//        acc.addTransaction(1000,"withdraw");
//        acc.addTransaction(100000,"withdraw");
//        acc.printTransaction();
//    }


}
