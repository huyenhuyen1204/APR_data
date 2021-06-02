import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    public List<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            Transaction depositTran = new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(depositTran);
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                balance -= amount;
                Transaction withdrawTran = new Transaction(Transaction.WITHDRAW, amount, balance);
                transitionList.add(withdrawTran);
            }
        }
    }

    /**
     * Them giao dich.
     * @param amount so tien giao dich.
     * @param operation phuong thuc giao dich.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == Transaction.DEPOSIT) {
                deposit(amount);
            }
            if (operation == Transaction.WITHDRAW) {
                withdraw(amount);
            }
        }
    }

    /**
     * In ra lich su giao dich.
     */
    public void printTransaction() {
        int j = 1;
        for (Transaction i : transitionList) {
            String s = null;
            if (i.getOperation().equals(Transaction.DEPOSIT)) {
                s = String.format("Giao dich %s: Nap tien $%.2g. So du luc nay: $%.2g."
                        , j, i.getAmount(), i.getBalance());
            }
            if (i.getOperation().equals(Transaction.WITHDRAW)) {
                s = String.format("Giao dich %s: Rut tien $%.2g. So du luc nay: $%.2g."
                        , j, i.getAmount(), i.getBalance());
            }
            System.out.println(s);
            j++;
        }
    }
}
