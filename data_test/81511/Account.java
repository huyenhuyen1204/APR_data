import java.util.ArrayList;

public class Account {

    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * fiora.
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;

        }
    }

    /**
     * lucian.
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * ramus.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            if (amount < 0) {
                return;
            }
            this.balance -= amount;
            transitionList.add(new Transaction("deposit", amount, this.balance));
        } else if (operation.equals("withdraw")) {
            if (amount < 0 || amount > this.balance) {
                return;
            }
            this.balance += amount;
            transitionList.add(new Transaction("withdraw", amount, this.balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * fjsahkjf.
     */
    public void setBanlance(double balance) {
        this.balance = balance;
    }

    /**
     * dfasgsfdf.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * iloveyou.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double amount = transitionList.get(i).getAmount();
            double balances = transitionList.get(i).getBalance();
            amount = (double) Math.round(amount * 100) / 100;
            balances = (double) Math.round(balances * 100) / 100;
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $"
                        + amount + ". So du luc nay: $" + balances + ".");
            } else if (transitionList.get(i).getOperation().equals("withdraw")) {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $"
                        + amount + ". So du luc nay: $" + balances + ".");
            }
        }
    }
}
