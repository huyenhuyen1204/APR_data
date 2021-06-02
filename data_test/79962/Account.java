import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    /**
     * main.
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * main.
     */
    private void withdraw(double amount) {
        if(amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        if (amount > balance) {
            System.out.println("So tien rut vout qua so du tai khoan!");
        } else {
            balance -= amount;
        }
    }

    /**
     * main.
     */
    public void addTransaction(double amount, String operation) {
        if (!operation.equals(Transaction.WITHDRAW) && !operation.equals(Transaction.DEPOSIT)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation.equals(Transaction.WITHDRAW)) {
                withdraw(amount);
            }
            if (operation.equals(Transaction.DEPOSIT)) {
                deposit(amount);
            }
            transactionList.add(new Transaction(operation, amount, balance));
        }
    }

    /**
     * main.
     */
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            String operation = "";
            if (transactionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                operation = "Nap tien";
            } else {
                operation = "Rut tien";
            }
            System.out.printf("Giao dich %d: %s $%.02f. "
                            + "So du luc nay: $%.02f.\n",
                    i + 1, operation, transactionList.get(i).getAmount(),
                    transactionList.get(i).getBalance());
        }
    }

//    /**
//     * Cmt.
//     */
//    public static void main(String[] args) {
//        Account acc = new Account();
//        acc.addTransaction(2000.255, "deposit");
//        acc.addTransaction(1000, "withdraw");
//        acc.printTransaction();
//    }
}
 