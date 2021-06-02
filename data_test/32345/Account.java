import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount){
        if(amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            balance += amount;
        }
    }

    private void withdraw(double amount){
        if(amount <=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else{
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation){
        if(operation != Transaction.DEPOSIT && operation != Transaction.WITHDRAW)
        {
            System.out.println("Yeu cau khong hop le!");
        }
        else if(operation == Transaction.DEPOSIT){
            this.deposit(amount);
            transitionList.add(new Transaction("Nap tien", amount, balance));
        }
        else if(operation == Transaction.WITHDRAW)
        {
            this.withdraw(amount);
            transitionList.add(new Transaction("Rut tien", amount, balance));
        }
    }

    public void printTransaction(){
        for(int x = 0; x < transitionList.size();  x ++){
            int i = x + 1;
            System.out.println("Giao dich " + i + ": " + transitionList.get(x).getOperation() + " " + "$" +transitionList.get(x).getAmount() + ".So du luc nay: " + "$" + transitionList.get(x).getBalance() +".");
        }
    }

    public static void main(String args[]){
        Account acc = new Account();
        acc.addTransaction(3000.68,"deposit");
        acc.addTransaction(3000.00, "deposit");
        acc.addTransaction(1000.00, "withdraw");
        acc.addTransaction(2000.00,"withdraw");
        acc.printTransaction();
    }
}

