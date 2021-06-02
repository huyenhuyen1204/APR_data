import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**
     * jvbf.
     */
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * jvbf.
     */
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    /**
     * jvbf.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            int kt = 0;
            if (operation.equals("withdraw")) {
                double x = balance;
                withdraw(amount);
                if (x != balance) {
                    kt = 1;
                }
            }
            if (operation.equals("deposit")) {
                double x = balance;
                deposit(amount);
                if (x != balance) {
                    kt = 1;
                }
            }
            if (kt == 1) {
                Transaction transaction = new Transaction(operation, amount, balance);
                transitionList.add(transaction);
            }
        }
    }

    /**
     * jvbf.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $");
            }
            if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.print("Rut tien $");
            }
            System.out.print(lt(transitionList.get(i).getAmount()) + ".");
            System.out.print(" So du luc nay: $");
            System.out.println(lt(transitionList.get(i).getBalance()) + ".");
        }
    }

    /**
     * jvbf.
     */
    public String lt(double amount) {
        double x = (double) (Math.round(amount * 100)) / 100;
        double temp = x - Math.round(x);
        if (temp == 0) {
            return "" + x + "0";
        }

        return "" + x;
    }
}
