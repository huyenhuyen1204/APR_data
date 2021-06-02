import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount >= balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * hung.
     */
    public void addTransaction(double amount, String operation) {
        if (operation == Transaction.DEPOSIT) {
            deposit(amount);
            Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(transaction);
        } else if (operation == Transaction.WITHDRAW) {
            withdraw(amount);
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * hung.
     */
    public String lamtron(double a) {
        long b = Math.round(a * 100);
        String str = Integer.toString((int) b);
        str = new StringBuilder(str).insert(str.length() - 2, ".").toString();
        return str;
    }

    /**
     * hung.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation() == transitionList.get(i).DEPOSIT) {
                System.out.println("Giao dich " + (i + 1)
                        + ": Nap tien $" + lamtron(transitionList.get(i).getAmount())
                        + ". So du luc nay: $" + lamtron(transitionList.get(i).getBalance()) + ".");
            }
            if (transitionList.get(i).getOperation() == transitionList.get(i).WITHDRAW) {
                System.out.println("Giao dich " + (i + 1)
                        + ": Rut tien $" + lamtron(transitionList.get(i).getAmount())
                        + ". So du luc nay: $" + lamtron(transitionList.get(i).getBalance()) + ".");
            }
        }
    }
}
