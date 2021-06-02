import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private int count = 1;
    private ArrayList<String> transaction = new ArrayList<>();


    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            String result = "Giao dich " + count + ": Nap tien " + "$" + Math.round(amount * 100.0) / 100.0 + ". So du luc nay: " + "$" + Math.round(balance * 100.0) / 100.0 + ".";
            count += 1;
            transaction.add(result);
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            String result = "Giao dich " + count + ": Rut tien " + "$" + Math.round(amount * 100.0) / 100.0 + ". So du luc nay: " + "$" + Math.round(balance * 100.0) / 100.0 + ".";
            count += 1;
            transaction.add(result);
        }
    }

    public void addTransaction(double amount, String operation) {
        switch (operation) {
            case Transaction.type_1:
                deposit(amount);
                break;
            case Transaction.type_2:
                withdraw(amount);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (String s : transaction) {
            System.out.println(s);
        }
    }
}
