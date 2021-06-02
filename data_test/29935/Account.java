import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    public Account(){
        this.balance = 0;
    }

    private void deposit(double amount){
        if (amount<=0)
            System.out.println("So tien ban nap vao khong hop le!");
        else{
            this.balance = this.balance + amount;
        }
    }

    private void withdraw(double amount){
        if (amount<=0)
            System.out.println("So tien ban rut ra khong hop le!");

        else if (amount>this.balance)
            System.out.println("So tien ban rut vuot qua so du!");

        else
            this.balance = this.balance - amount;
    }

    public void addTransaction(double amount, String operation){
        if (operation.equals(Transaction.DEPOSIT)){
            deposit(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        }

        else if (operation.equals(Transaction.WITHDRAW)){
            withdraw(amount);
            Transaction transaction = new Transaction(operation, amount, this.balance);
            transitionList.add(transaction);
        }

        else{
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction(){
        for(int i=0; i<transitionList.size(); i++){
            if (transitionList.get(i).getOperation().equals("deposit")){
                String s = "Giao dich " + (i+1) + ": Nap tien $" + (double)Math.round(transitionList.get(i).getAmount()*100)/100
                        + ". So du luc nay: " + (double)Math.round(transitionList.get(i).getBalance()*100)/100 + ".";
                System.out.println(s);
            }

            if (transitionList.get(i).getOperation().equals("withdraw")){
                String s = "Giao dich " + (i+1) + ": Rut tien $" + (double)Math.round(transitionList.get(i).getAmount()*100)/100
                        + ". So du luc nay: $" + (double)Math.round(transitionList.get(i).getBalance()*100)/100 + ".";
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Account H = new Account();
        H.addTransaction(2000.255,"deposit");
        H.addTransaction(1000,"withdraw");
        H.printTransaction();
    }
}
