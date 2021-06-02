import java.util.ArrayList;

public class Account {
    private int count;
    private double balance = 0;
    private ArrayList<String> arrayList = new ArrayList<String>();
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     *addTransaction.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            Transaction newTransaction = new Transaction(operation, amount, 0);
            transitionList.add(newTransaction);
        }
    }

    /**
     * printtransaction.
     */
    public void printTransaction() {
        String str;
        for (int i = 0; i < transitionList.size(); ++i) {
            count += 1;
            if (transitionList.get(i).getOperation().equals("deposit")) {
                balance += transitionList.get(i).getAmount();
                str = "Giao dich " + count + ": " + "Nap tien " + transitionList.get(i).getAmount()
                        + ". " + "So du luc nay: " + balance + ".";
                arrayList.add(str);
            } else {
                balance -= transitionList.get(i).getAmount();
                str = "Giao dich " + count + ": " + "Rut tien " + transitionList.get(i).getAmount()
                        + ". " + "So du luc nay: " + balance + ".";
                arrayList.add(str);
            }
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            System.out.println(arrayList.get(i));
        }
    }

}
