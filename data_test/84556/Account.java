import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {

            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance = balance + amount;

        }
    }


    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println(" So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            balance = balance - amount;
        }
    }

    /**
     * add.
     */
    public void addTransaction(double amount, String operation) {

        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * print.
     */
    public void printTransaction() {
        int count = 1;
        for (Transaction transaction : transitionList) {

            if (transaction.getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (count) + ": Nap tien" + transaction.toString());
            } else if (transaction.getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (count) + ": Rut tien" + transaction.toString());
            }
            count++;
        }
    }
    
}





