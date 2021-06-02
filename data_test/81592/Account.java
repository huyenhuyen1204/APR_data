import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> historyTrans = new ArrayList<Transaction>();

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.historyTrans.add(new Transaction("deposit",amount,this.balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            this.balance -= amount;
            this.historyTrans.add(new Transaction("withdraw",amount,this.balance));
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    void addTransaction(double amount, String operation) {
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

    public void printTransaction() {
        for (int i =0;i<this.historyTrans.size();i++) {
            System.out.printf("Giao dich "+ (i+1) + ": ");
            if (this.historyTrans.get(i).getOperation().equals("deposit")) {
                System.out.printf("Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        this.historyTrans.get(i).getAmount(),this.historyTrans.get(i).getBalance());
            }

            if (this.historyTrans.get(i).getOperation().equals("withdraw")) {
                System.out.printf("Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        this.historyTrans.get(i).getAmount(),this.historyTrans.get(i).getBalance());
            }
        }
    }
}
