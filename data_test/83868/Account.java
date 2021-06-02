import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    /** Deposit function. **/
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        transactions.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
    }

    /** Withdraw function. **/
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
    }

    /** Add new transaction. **/
    public void addTransaction(double amount, String operation) {
        switch (operation) {
            case Transaction.DEPOSIT:
                deposit(amount);
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }

    /** Print ... transactions. **/
    public void printTransaction() {
        for (int i = 1; i <= transactions.size(); ++ i) {
            String roundedAmount = String.format("%.2f", transactions.get(i - 1).getAmount());
            String roundedBalance = String.format("%.2f", transactions.get(i - 1).getBalance());
            String operation;
            if (transactions.get(i - 1).getOperation().equals(Transaction.DEPOSIT)) {
                operation = "Nap";
            } else {
                operation = "Rut";
            }
            System.out.println("Giao dich " + i + ": " + operation + " tien $" + roundedAmount
                    + ". So du luc nay: $" + roundedBalance);
        }
    }

    /** Test. **/
    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.addTransaction(15.255, "deposit");
        myAccount.addTransaction(10.355, "withdraw");
        myAccount.printTransaction();
    }
}
