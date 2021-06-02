import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();


    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == Transaction.WITHDRAW) {
                transactions.add( new Transaction(operation, amount, balance));
                balance -= amount;
            } else {
                if (operation == Transaction.DEPOSIT) {
                    transactions.add( new Transaction(operation, amount, balance));
                    balance += amount;
                }
            }

        }
    }

    private void deposit(double amount) {
        if (amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else {
            addTransaction(amount,Transaction.DEPOSIT);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance) System.out.println("So tien ban rut ra vuot qua so du!");
        else {
            addTransaction(amount,Transaction.WITHDRAW);
        }
    }

    public void printTransaction() {
        int cnt = 1;
        for (Transaction temp : transactions) {
            if (temp.getOperation() == Transaction.DEPOSIT) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: %.2f.\n", cnt,temp.getAmount(), temp.getBalance());
            } else if (temp.getOperation() == Transaction.WITHDRAW) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: %.2f.\n", cnt,temp.getAmount(), temp.getBalance());
            }
            cnt++;
        }
    }


    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();

    }
}
