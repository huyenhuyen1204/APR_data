import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();
    /**
     * do nothing.
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transitionList.add(new Transaction("deposit",amount,this.balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }
    /**
     * do nothing.
     */
    private void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            this.balance -= amount;
            this.transitionList.add(new Transaction("withdraw",amount,this.balance));
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }
    /**
     * do nothing.
     */
    public void addTransaction(double amount, String operation) {
        if (operation != "deposit" && operation != "withdraw") {
            System.out.println("Yeu cau khong hop le!");
        }
        if (operation == "deposit") {
            this.deposit(amount);
        }
        if (operation == "withdraw") {
            this.withdraw(amount);
        }
    }
    /**
     * do nothing.
     */
    public void printTransaction() {
        for (int i =0;i<this.transitionList.size();i++) {
            System.out.printf("Giao dich "+ (i+1) + ": ");
            if (this.transitionList.get(i).getOperation().equals(this.transitionList.get(i).DEPOSIT)) {
                System.out.printf("Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        this.transitionList.get(i).getAmount(),this.transitionList.get(i).getBalance());
            }

            if (this.transitionList.get(i).getOperation().equals(this.transitionList.get(i).WITHDRAW)) {
                System.out.printf("Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        this.transitionList.get(i).getAmount(),this.transitionList.get(i).getBalance());
            }
        }
    }
}
