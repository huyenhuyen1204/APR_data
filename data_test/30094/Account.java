import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account(){}
    private List<Transaction> transitionList = new ArrayList<Transaction>();
    private void deposit (double amount){
        if (amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else {
            this.balance += amount;
            transitionList.add(new Transaction("deposit" , amount, this.balance));
        }
    }
    private void withdraw (double withdraw){
        if (withdraw <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (withdraw > this.balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else {
            this.balance -= withdraw;
            transitionList.add(new Transaction("withdraw" , withdraw, this.balance));
        }
    }
    public void addTransaction (double amount, String operation){
        if (operation == Transaction.DEPOSIT) {
            this.deposit(amount);
        }
        else if (operation == Transaction.WITHDRAW) {
            this.withdraw(amount);
        }
        else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction(){
        int size = this.transitionList.size();
        for (int i= 0 ; i < size; i++){
            String o = this.transitionList.get(i).getOperation();
            if (o == "deposit")
                System.out.println("Giao dich " + (i+1) + ": Nap tien $" +
                        this.transitionList.get(i).getAmount() + ". So du luc nay: $" + this.transitionList.get(i).getBalance() + ".");
            else  {
                System.out.println("Giao dich " + (i+1) + ": Rut tien $" +
                        this.transitionList.get(i).getAmount() + ". So du luc nay: $" + this.transitionList.get(i).getBalance() + ".");
            }
        }
    }

    public static void main(String[] args) {
//        Account account = new Account();
//        account.addTransaction(1000, "deposit");
//        account.addTransaction( 30 , "withdraw");
//        account.addTransaction(-3,"withdraw" );
//        account.addTransaction(5, "withdraw");
//        account.printTransaction();
    }
}
