import java.math.BigDecimal;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount >0) {
            balance += amount;
        } else {
            System.out.print("So tien ban nap vao khong hop le!\n");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            if (amount > balance) {
                System.out.print("So tien ban rut vuot qua so du!\n");
            } else {
                System.out.print("So tien ban rut ra khong hop le!\n");
            }
        }
    }

    public void addTransaction(double amount, String operation) {
        if (!operation.equalsIgnoreCase(Transaction.DEPOSIT)
                && !operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            withdraw(amount);
        }
        Transaction transaction = new Transaction(operation, amount, balance);
        transitionList.add(transaction);
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            int index = i + 1;
            System.out.print("Giao dich " + index + ": ");
            if (transitionList.get(i).getOperation().equalsIgnoreCase(Transaction.DEPOSIT)) {
                System.out.print("Nap tien ");
            } else {
                System.out.print("Rut tien ");
            }

            System.out.print("$" +
                    BigDecimal.valueOf(transitionList.get(i).getAmount()).
                            setScale(2, BigDecimal.ROUND_HALF_UP) + ".");
            System.out.print(" So du luc nay: $" +
                    BigDecimal.valueOf(transitionList.get(i).getBalance()).
                            setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.print(".\n");
        }
    }
}
