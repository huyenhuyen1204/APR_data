import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionArrayList = new ArrayList<Transaction>();

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
            transactionArrayList.add(new Transaction("deposit", amount, balance));
        }
        else if(operation == Transaction.WITHDRAW)
        {
            this.withdraw(amount);
            transactionArrayList.add(new Transaction("withdraw", amount, balance));
        }
    }

    public void printTransaction(){
        for(int x = 0; x < transactionArrayList.size();  x ++){
            
        }
    }

    public static void main(String args[]){
        Account acc = new Account();
        acc.addTransaction(2000.225,"deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}

