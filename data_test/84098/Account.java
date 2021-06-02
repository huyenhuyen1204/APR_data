import java.util.ArrayList;

public class Account extends Transaction {
    private double balance;

    public Account(String operation, double amount, double blance) {
        super(operation, amount, blance);
    }

    public Account() {
    }

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        this.balance += amount;
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
    }

    private final ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     *Add a new transaction to the list.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            this.deposit(amount);
            if (amount > 0) {
                Transaction transaction
                        = new Transaction("Nap tien", amount, this.balance);
                this.transitionList.add(transaction);
            }
            return;
        }
        if (operation.equals("withdraw")) {
            this.withdraw(amount);
            if (amount > 0 && amount <= this.balance) {
                Transaction transaction
                        = new Transaction("Rut tien", amount, this.balance);
                this.transitionList.add(transaction);
            }
            return;
        }
        System.out.println("Yeu cau khong hop le!");
    }

    /**
     *Print out the information of the transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < this.transitionList.size(); i++) {
            Transaction transaction = this.transitionList.get(i);
            String text = "";
            text += "Giao dich " + (i + 1) + ": " + transaction.getOperation();
            text += " $" + this.approximately(transaction.getAmount()) + ". ";
            text += "So du luc nay: $" + this.approximately(transaction.getBalance()) + ".";
            System.out.println(text);
        }
    }

    public String approximately(double x) {
        x = (double) Math.round(x * 100) / 100;
        return String.format("%.2f", x);
    }
}
