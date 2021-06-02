import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private String deposit;
    private String withdraw;

    /**2.*/
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**2.*/
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut khong hop le!");
        } else if (amount < balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**2.*/
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            boolean check = false;
            if (operation.equals("deposit")) {
                double balance1 = balance;
                deposit(amount);
                if (balance == balance1 - amount) {
                    check = true;
                }
            }
            if (operation.equals("withdraw")) {
                double balance1 = balance;
                withdraw(amount);
                if (balance == balance1 - amount) {
                    check = true;
                }
            }
            if (check) {
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            }
        }
    }

    /**2.*/
    public void printTransaction() {
        for (int i = 1; i <= transitionList.size(); i++) {
            System.out.println("Giao dich " + i + ": ");
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Nap tien $");
            }
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.println("Rut tien $");
            }
            System.out.println("" + Math.round(transitionList.get(i).getAmount()) + ". ");
            System.out.println("So du luc nay: $"
                    + Math.round(transitionList.get(i).getBalance()) + ".");
        }
    }
}
