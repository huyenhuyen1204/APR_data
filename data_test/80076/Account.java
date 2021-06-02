import java.util.ArrayList;

public class Account {
    private double balance;  //thông tin về số dư tài khoản ngân hàng
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>(100);
    private ArrayList<String> historyTransaction = new ArrayList<String>(100);
    private int count = 0;

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            count++;
            String temp = String.format("%.2f", amount);
            String temp1 = String.format("%.2f", balance);
            String tung = String.valueOf(count);
            historyTransaction.add("Giao dich " + tung + ": Nap tien $" + temp
                    + ". So du luc nay: $" + temp1 + ".");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
            count++;
            String temp3 = String.format("%.2f", amount);
            String temp4 = String.format("%.2f", balance);
            String tung1 = String.valueOf(count);
            historyTransaction.add("Giao dich " + tung1 + ": Rut tien $"
                    + temp3 + ". So du luc nay: $" + temp4 + ".");
        }
    }

    /**
     * tung.
     */
    public void addTransaction(double amount, String operation) {
        if (operation != "deposit" && operation != "withdraw") {
            System.out.println("Yeu cau khong hop le!");
        } else if (operation == "deposit") {
            deposit(amount);
        } else {
            withdraw(amount);
        }
    }

    /**
     * tung.
     */
    public void printTransaction() {
        for (int i = 0; i < historyTransaction.size(); i++) {
            System.out.println(historyTransaction.get(i));
        }
    }
}
