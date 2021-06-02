import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * add transaction.
     *
     * @param amount amount.
     * @param operation operation.
     */
    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == Transaction.DEPOSIT) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        }
    }

    /**
     * print transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String s = "Giao dich " + (i + 1) + ": ";
            if (transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                s += "Nap tien ";
            } else {
                s += "Rut tien ";
            }
            s += String.format("%.2f", transitionList.get(i).getAmount()) + ". So du luc nay: "
                    + String.format("%.2f", transitionList.get(i).getBalance()) + ".";
            System.out.println(s);
        }
    }
}
