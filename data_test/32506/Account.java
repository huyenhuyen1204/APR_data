import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    private void deposit(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else
            balance += amount;
    }

    private void withdraw(double amount) {
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance)
                System.out.println("So tien ban rut vuot qua so du!");
            else balance -= amount;
    }

    public void addTransaction(double amount, String operation) {
        if (!(operation.equals("deposit") || operation.equals("withdraw")))
            System.out.println("Yeu cau khong hop le!");
        else if (operation.equals("deposit")) {
            deposit(amount);
            if (amount > 0)
                    transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        } else {
            withdraw(amount);
            if ((amount > 0) && (amount <= balance))
                transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double tempAmount = Math.round(transitionList.get(i).getAmount() * 100) / 100;
            double tempBalance = Math.round(transitionList.get(i).getBalance() * 100) / 100;
            System.out.println("Giao dich " + i + ": " + transitionList.get(i).getOperation()
            + " $" + tempAmount + ". " + "So du luc nay: $" + tempBalance + ".");
        }
    }
}
