import java.util.ArrayList;

public class Account {

    private double balance; //số dư tài khoảng ngân hàng
    private ArrayList<Transaction> transactions; //lịch sử giao dịch

    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
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
                transactions.add(new Transaction(operation, amount, balance));
            }
            else System.out.println("So tien ban nap vao khong hop le!");
        }
        else if (operation == "withdraw") {
            operation = Transaction.WITHDRAW;
            if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
            else if (amount > balance) System.out.println("So tien ban rut vuot qua so du!");
            else {
                withdraw(amount);
                transactions.add(new Transaction(operation, amount, balance));
            }
        }
        else System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i=0; i<transactions.size(); i++) {
            System.out.println(
                    "Giao dich "+ (i+1) +": "+ transactions.get(i).getOperation() +" tien $"
                            + (double) Math.round(transactions.get(i).getAmount()*100)/100 +". So du luc nay: $"
                            + (double) Math.round(transactions.get(i).getBalance()*100)/100 +"."
            );
        }
    }
}
