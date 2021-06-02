import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private String Format(double x) {
        DecimalFormat fr = new DecimalFormat("#.00");
        double s = Math.floor((x + 0.005) * 100) / 100;
        return fr.format(s);
    }

    private double balance = 0;
    private ArrayList<String> historyTransaction = new ArrayList<String>();

    private void deposit(double amount) {   // Nạp tiền vào tài khoản
        balance += amount;
        String s = "Giao dich " + Integer.toString(historyTransaction.size() + 1)
                + ": Nap tien $" + Format(amount) + ". So du luc nay: $" + Format(balance);
        historyTransaction.add(s);
    }

    private void withdraw(double amount) {  // rút tiền
        //Số tiền amount >0; ngược lại int ra: "So tien khong hop le!"
        if (amount <= 0) {
            System.out.println("So tien khong hop le!");
        } else if (amount > balance) {   // Nếu số tiền lớn hơn số dư, in ra "So tien ban rut vuot qua so du!"
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            String s = "Giao dich " + Integer.toString(historyTransaction.size() + 1)
                    + ": Rut tien $" + Format(amount) + ". So du luc nay: $" + Format(balance);
            historyTransaction.add(s);
        }

    }

    public void addTransaction (double amount, String operation) {   // thêm giao dịch
        if ((operation.toLowerCase()).equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if ((operation.toLowerCase()).equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
    }
    public  void  printTransaction()    {
        for(int i=0; i< historyTransaction.size(); i++) {
            System.out.println(historyTransaction.get(i));
        }
    }

}
