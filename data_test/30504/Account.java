import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {


    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private String Format(double x) {
        DecimalFormat fr = new DecimalFormat("#.00");
        double s = Math.floor((x + 0.005) * 100) / 100;
        return fr.format(s);
    }

    private void deposit(double amount) {   // Nạp tiền vào tài khoản
        balance += amount;

        Transaction transaction = new Transaction(Transaction.DEPOSIT, amount, balance);
        transitionList.add(transaction);
    }

    private void withdraw(double amount) {  // rút tiền
        //Số tiền amount >0; ngược lại int ra: "So tien khong hop le!"
        if (amount <= 0) {
            System.out.println("So tien khong hop le!");
        } else if (amount > balance) {   // Nếu số tiền lớn hơn số dư, in ra "So tien ban rut vuot qua so du!"
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            transitionList.add(transaction);
        }

    }

    public void addTransaction(double amount, String operation) {   // thêm giao dịch
        if ((operation.toLowerCase()).equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if ((operation.toLowerCase()).equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                String s = "Giao dich " + Integer.toString(i + 1)
                        + ": Nap tien $" + Format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + Format(transitionList.get(i).getBalance()) + ".";
                System.out.println(s);
            } else {
                String s = "Giao dich " + Integer.toString(transitionList.size() + 1)
                        + ": Rut tien $" + Format(transitionList.get(i).getAmount()) + ". So du luc nay: $" + Format(balance) + ".";
                System.out.println(s);
            }
        }
    }

}
