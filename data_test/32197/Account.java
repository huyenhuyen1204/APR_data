import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;
        transitionList.add(new Transaction(amount, balance, Transaction.DEPOSIT));
    }

    private void withdraw(double amount) {
        if (amount <= 0 ) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        else if(amount > balance)
        {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
        transitionList.add(new Transaction(amount, balance, Transaction.WITHDRAW));
    }

    public void addTransaction(double amount, String operation)
    {
        switch (operation)
        {
            case Transaction.DEPOSIT:
                deposit(amount);
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }

    public void printTransaction()
    {
        for(int i = 0; i < transitionList.size(); ++i)
        {
            System.out.print("Giao dich " + (i + 1) + ": ");
            transitionList.get(i).print();
        }
    }
    public static void main(String[] args)
    {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
