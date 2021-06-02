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

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            Transaction transaction = new Transaction(operation, amount, balance);
            deposit(amount);
            transitionList.add(transaction);
        }
        else if  (operation.equals(Transaction.WITHDRAW)) {
            Transaction transaction = new Transaction(operation, amount, balance);
            withdraw(amount);
            transitionList.add(transaction);
        } else if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        int count = 1;
        for (Transaction tr : transitionList) {

            if (tr.getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (count) + ": Nap tien" + tr.toString());
            } else if (tr.getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (count) + ": Rut tien" + tr.toString());
            }
            count++;
        }
    }

}





