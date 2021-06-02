import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {

            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;

        }
    }


    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println(" So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            balance -= amount;
        }
    }

    /**
     * addTransaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction trans = new Transaction(operation, amount, balance);
            transitionList.add(trans);
        } else {
            withdraw(amount);
            Transaction trans = new Transaction(operation, amount, balance);
            transitionList.add(trans);
        }
    }

    /**
     * printTransaction.
     */
    public void printTransaction() {
        int dem = 1;
        for (Transaction trans : transitionList) {

            if (trans.getOperation().equals("deposit")) {
                System.out.println("Giao dich " + dem + ": Nap tien" + trans.toString());
            } else if (trans.getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + dem + ": Rut tien" + trans.toString());
            }
            dem++;
        }
    }

}





