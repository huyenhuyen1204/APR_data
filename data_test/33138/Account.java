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
        transitionList.add(new Transaction("Nap tien",amount, balance));
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
        transitionList.add(new Transaction("Rut tien",amount, balance));
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

    public void  printTransaction(){
        int i = 1 ;
        for ( Transaction item : transitionList){
            System.out.printf("Giao dich " + i +  ": "+item.getOperation() + " $%.2f. So du luc nay: $%.2f.\n", item.getAmount(), item.getBalance());
            i++;
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
