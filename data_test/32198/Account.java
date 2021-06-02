import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount){
        if(amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else
            balance += amount;
    }

    private void withdraw(double amount){
        if (amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if (amount > balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else
            balance -= amount;
    }

    public void addTransaction(double amount, String operation){
        if (!operation.equals("deposit") && !operation.equals("withdraw"))
            System.out.println("Yeu cau khong hop le!");
        if (operation.equals("deposit"))
            deposit(amount);
        else if (operation.equals("withdraw"))
            withdraw(amount);
        Transaction newTransaction = new Transaction(operation,amount,balance);
        transitionList.add(newTransaction);
    }

    public void printTransaction(){
        for (int i = 0; i < transitionList.size(); i++) {
            double amount_temp = Math.round(transitionList.get(i).getAmount() * 100);
            double balance_temp = Math.round(transitionList.get(i).getBalance() * 100);
            System.out.print("Giao dich " + (i+1) + ": ");
            if (transitionList.get(i).getOperation().equals("deposit"))
                System.out.println("Nap tien $" + (amount_temp/100) + ". So du luc nay: $" + (balance_temp/100) + ".");
            else if (transitionList.get(i).getOperation().equals("withdraw"))
                System.out.println("Nap tien $" + (amount_temp/100) + ". So du luc nay: $" + (balance_temp/100) + ".");
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
