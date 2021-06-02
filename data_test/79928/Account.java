import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /** Missing a java doc. */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        Transaction tran = new Transaction("deposit", amount, balance);
        transitionList.add(tran);
    }

    /** Missing a java doc. */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        Transaction tran = new Transaction("withdraw", amount, balance);
        transitionList.add(tran);
    }

    /** Missing a java doc. */
    public void addTransaction(double amount, String operation) {
        if (operation == "DEPOSIT" | operation == "deposit") {
            deposit(amount);
        } else if (operation == "withdraw" | operation == "WITHDRAW") {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** Missing a java doc. */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            String s = "";
            if (transitionList.get(i).getOperation() == "deposit") {
                s = "Nap tien $";
            } else {
                s = "Rut tien $";
            }
            double amount = transitionList.get(i).getAmount();
            double bal = transitionList.get(i).getBalance();
            String a = String.format("%.2f", amount);
            String b = String.format("%.2f", bal);
            String s1 = ". So du luc nay: $";
            System.out.println("Giao dich "
                    + (i + 1)
                    + ": "
                    + s
                    + a
                    + s1
                    + b
                    + "."
            );
        }
    }
}
