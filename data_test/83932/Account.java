

import java.util.ArrayList;


public class Account {
    private double balance;
    private ArrayList<Transaction> list = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;

        }
    }

    /*
     * addTransaction.
     */
    public void addTransaction(double a, String o) {
        if (o.equals(Transaction.DEPOSIT) == true) {
            deposit(a);
            Transaction transaction = new Transaction(o, a, balance);
            list.add(transaction);
        } else if (o.equals(Transaction.WITHDRAW) == true) {
            withdraw(a);
            Transaction transaction = new Transaction(o, a, balance);
            list.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }

    /*
     * withdraw.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;

        }
    }

    /*
     * printTransaction.
     */
    public void printTransaction() {
        for (int i = 0; i < list.size(); i++) {
            if (((double) Math.round(list.get(i).getAmount() * 100) / 100
                    - list.get(i).getAmount()) == 0.0
                    || ((double) Math.round(list.get(i).getBalance() * 100) / 100
                    - list.get(i).getBalance()) == 0.0) {
                if (list.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                    System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                            + (double) Math.round(list.get(i).getAmount() * 100) / 100
                            + "0. So du luc nay: $"
                            + (double) Math.round(list.get(i).getBalance() * 100) / 100 + ".");
                }
                if (list.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                    System.out.println("Giao dich " + (i + 1) + ": Rut tien $"
                            + (double) Math.round(list.get(i).getAmount() * 100) / 100
                            + "0. So du luc nay: $"
                            + (double) Math.round(list.get(i).getBalance() * 100) / 100 + ".");
                }
            } else {
                if (list.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                    System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                            + (double) Math.round(list.get(i).getAmount() * 100) / 100
                            + ". So du luc nay: $"
                            + (double) Math.round(list.get(i).getBalance() * 100) / 100 + ".");
                }
                if (list.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                    System.out.println("Giao dich " + (i + 1) + ": Rut tien $"
                            + (double) Math.round(list.get(i).getAmount() * 100) / 100
                            + ". So du luc nay: $"
                            + (double) Math.round(list.get(i).getBalance() * 100) / 100 + ".");
                }
            }
        }
    }

   /* public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000.0, "withdraw");
        acc.printTransaction();
        double a = 1000;
        double b = 1000.0;

//System.out.println(b+"0");
    }*/

}
