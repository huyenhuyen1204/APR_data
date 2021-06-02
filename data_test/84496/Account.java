import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation != "deposit" && operation != "withdraw") {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (operation == "deposit") {
                deposit(amount);
            } else if (operation == "withdraw") {
                withdraw(amount);
            }
            Transaction newTrans = new Transaction(operation, amount, this.balance);
            transitionList.add(newTrans);
        }
    }

    public void printTransaction() {
        String s = "";
        for (int i = 0; i < transitionList.size(); i++) {
            s += "Giao dich " + (i + 1) + ": ";
            if (transitionList.get(i).getOperation() == "deposit")
                s += "Nap tien ";
            else s += "Rut tien ";
            s += "$" + String.format("%.2f", transitionList.get(i).getAmount()) + ". ";
            s += "So du luc nay: $" + String.format("%.2f", transitionList.get(i).getBalance()) + ". "+"\n";
        }
        System.out.println(s);
    }
}
