import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance; // số tiền dư trong tài khoản
    private ArrayList<Transaction> transitionList = new ArrayList<>(); // list giao dịch


    public void printTransaction(){
        int i=1;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (Transaction tran : transitionList) {
            switch (tran.getOperation()){
                case Transaction.DEPOSIT:
                    System.out.println("Giao dich " + i
                            + ": Nap tien " + decimalFormat.format(tran.getAmount())
                            + ". So du luc nay: " + decimalFormat.format(tran.getBalance()) + ".");
                    break;
                case Transaction.WITHDRAW:
                    System.out.println("Giao dich " + i
                            + ": Rut tien " + decimalFormat.format(tran.getAmount())
                            + ". So du luc nay: " + decimalFormat.format(tran.getBalance()) + ".");
                    break;
            }

            i++;
        }
    }

    public void addTransaction(double amount, String operation){
        switch (operation){
            case Transaction.DEPOSIT:
                deposit(amount);
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                break;
        }
    }

    private void deposit(double amount){
        if (amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance = this.balance + amount;
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
    }

    private void withdraw(double amount){
        if (amount <= 0){
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount > this.balance){
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance = this.balance - amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
        }
    }
}
