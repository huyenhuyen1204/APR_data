import java.util.ArrayList;

public class Account {
    private int count;
    private double balance = 0.0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction newTransaction = new Transaction("deposit", amount, balance);
            transitionList.add(newTransaction);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            Transaction newTransaction = new Transaction("withdraw", amount, balance);
            transitionList.add(newTransaction);
        }
    }

    /**
     *addTransaction.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println(" Yeu cau khong hop le!");
        }
    }

    /**
     * printtransaction.
     */
    public void printTransaction() {
        String str = "";
        for (int i = 0; i < transitionList.size(); ++i) {
            count = i + 1;
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                balance += transitionList.get(i).getAmount();
                str += "Giao dich " + count + ": " + "Nap tien $" + Math.round(transitionList.get(i).getAmount()*100.0)/100.0
                        + ". " + "So du luc nay: $" + Math.round(transitionList.get(i).getBalance()*100.0)/100.0 + ".\n";
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                balance -= transitionList.get(i).getAmount();
                str += "Giao dich " + count + ": " + "Rut tien $" + Math.round(transitionList.get(i).getAmount()*100.0)/100.0
                        + ". " + "So du luc nay: $" + Math.round(transitionList.get(i).getBalance()*100.0)/100.0 + ".\n";
            }
        }
        System.out.println(str);
    }
}
