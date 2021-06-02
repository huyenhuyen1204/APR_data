import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    private void deposit(double amount){
        amount = Math.round(amount * 100.0) / 100.0;

        if(amount <= 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            balance += amount;
            balance = Math.round(balance * 100.0) / 100.0;
        }
    }

    private void withdraw(double amount){
        amount = Math.round(amount * 100.0) / 100.0;
        if(amount <=0){
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else{
            balance -= amount;
            balance = Math.round(balance * 100.0) / 100.0;
        }
    }

    public void addTransaction(double amount, String operation){
        amount = Math.round(amount * 100.0) / 100.0;
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
            double amount = transitionList.get(x).getAmount();
            double balance = transitionList.get(x).getBalance();

            System.out.println("Giao dich " + i + ": " + transitionList.get(x).getOperation() + " " + "$" +String.format("%.2f", amount) + ". So du luc nay: " + "$" + String.format("%.2f",balance) +".");
        }
    }

    public static void main(String args[]){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}

