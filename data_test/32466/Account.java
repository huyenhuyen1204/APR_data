import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();


    public void addTransaction(double amount, String operation) {
        if (operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW) {
            transactionList.add(new Transaction(operation, amount,balance));
        } else {
            if (operation == Transaction.WITHDRAW) {
                withdraw(amount);
                transactionList.add( new Transaction(operation, amount, balance));

            } else {
                if (operation == Transaction.DEPOSIT) {
                    deposit(amount);
                    transactionList.add( new Transaction(operation, amount, balance));

                }
            }

        }
    }

    private void deposit(double amount) {
        if (amount <= 0) System.out.println("So tien ban nap vao khong hop le!");
        else {
            balance += amount;

        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance) System.out.println("So tien ban rut ra vuot qua so du!");
        else {
            balance -= amount;
        }
    }

    public void printTransaction() {
        int cnt = 1;
        for (Transaction temp : transactionList) {
            if (temp.getOperation() == Transaction.DEPOSIT) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", cnt,temp.getAmount(), temp.getBalance());
            } else if (temp.getOperation() == Transaction.WITHDRAW) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", cnt,temp.getAmount(), temp.getBalance());
            }
            else System.out.println("Yeu cau khong hop le!");
            cnt++;
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.addTransaction(3000,"abc");
        acc.printTransaction();

    }

}
