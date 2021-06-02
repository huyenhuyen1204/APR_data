import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    public Account() {

    }

    public void addTransaction(double amount,String operation) {
        Transaction a;
        if (operation.equals(Transaction.getDEPOSIT())) {
            deposit(amount);
            a = new Transaction(Transaction.getDEPOSIT(), amount, this.balance);
            transitionList.add(a);
        } else if (operation.equals(Transaction.getWITHDRAW())) {
            withdraw(amount);
            a = new Transaction(Transaction.getWITHDRAW(), amount, this.balance);
            transitionList.add(a);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }
    private void withdraw(double amount) {
        if (amount >= balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
        }
    }

    public void printTransaction() {
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < transitionList.size(); i++) {
            int order = i + 1;
            if (transitionList.get(i).getOperation().equals(Transaction.getWITHDRAW())) {
                double ddeposit = Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0;
                double dbalance = Math.round(transitionList.get(i).getBalance() * 100.0) / 100.0;
                String strDeposit = df.format(ddeposit);
                String strBalance = df.format(dbalance);
                System.out.println("Giao dich " + order + ": Rut tien $" + strDeposit
                        + ". So du luc nay: $" + strBalance + ".");
            } else if (transitionList.get(i).getOperation().equals(Transaction.getDEPOSIT())) {
                double dwithdraw = Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0;
                double dbalance = Math.round(transitionList.get(i).getBalance() * 100.0) / 100.0;
                String strWithdraw = df.format(dwithdraw);
                String strBalance = df.format(dbalance);
                System.out.println("Giao dich " + order + ": Nap tien $" + strWithdraw
                        + ". So du luc nay: $" + strBalance + ".");
            }
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
