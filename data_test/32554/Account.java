import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {

    private double balance; //số dư tài khoảng ngân hàng
    private ArrayList<Transaction> transitionList; //lịch sử giao dịch

    public Account() {
        balance = 0;
        transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        balance += amount;

    }

    private void withdraw(double amount) {
        balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (operation == "deposit") {
            operation = Transaction.DEPOSIT;
            if(amount > 0) {
                deposit(amount);
                transitionList.add(new Transaction(operation, amount, balance));
            }
            else System.out.println("So tien ban nap vao khong hop le!");
        }
        else if (operation == "withdraw") {
            operation = Transaction.WITHDRAW;
            if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
            else if (amount > balance) System.out.println("So tien ban rut vuot qua so du!");
            else {
                withdraw(amount);
                transitionList.add(new Transaction(operation, amount, balance));
            }
        }
        else System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i=0; i<transitionList.size(); i++) {
            DecimalFormat df = new DecimalFormat("##.00");

            System.out.println(
                    "Giao dich "+ (i+1) +": "+ transitionList.get(i).getOperation() +" tien $"
                            + df.format(transitionList.get(i).getAmount()) +". So du luc nay: $"
                            + df.format(transitionList.get(i).getBalance()) +"."
            );
        }
    }
}
