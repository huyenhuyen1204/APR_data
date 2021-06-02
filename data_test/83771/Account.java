import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;

    private List<Transaction> transitionList = new ArrayList<>();

    /**
     * pt nạp tiền vào tài khoản.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        balance += amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }

    /**
     * pt rút tiền.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        balance -= amount;
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }

    /**
     * pt thêm giao dịch vào danh sách giao dịch.
     * @param amount số tiền giao dịch
     * @param operation tên loại giao dịch
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * pt in tất cả các giao dịch.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                double tienNap = transitionList.get(i).getAmount();
                double tienDu = transitionList.get(i).getBalance();
                System.out.printf("Giao dich %d: Nap tien $%.2f. "
                        + "So du luc nay: $%.2f.\n", (i + 1), tienNap, tienDu);
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                double tienRut = transitionList.get(i).getAmount();
                double tienDu = transitionList.get(i).getBalance();
                System.out.printf("Giao dich %d: Rut tien $%.2f. "
                        + "So du luc nay: $%.2f.\n", (i + 1), tienRut, tienDu);
            }
        }
    }
}
