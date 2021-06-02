import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> arrayList = new ArrayList<>();

    //Nap tien
    public void deposit(double amount){
        if(amount>0){
            this.balance += amount;
            this.arrayList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
        }
        else System.out.println("So tien ban nap vao khong hop le!");
    }

    //Rut tien
    public void withdraw(double amount){
        if(amount>0) {
            if (amount <= balance) {
                balance -= amount;
                arrayList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
            }
            else System.out.println("So tien ban rut vuot qua so du!");
        }
        else System.out.println("So tien ban rut ra khong hop le");
    }

    public void addTransaction(double amount, String operation){
        if(operation == Transaction.DEPOSIT) deposit(amount);
        else if(operation == Transaction.WITHDRAW) withdraw(amount);
        else{
            System.out.println("Yeu cau khong hop le!");
        }
    }
    public void printTransaction(){
        for(Transaction x : arrayList){
            if(x.getOperation()== Transaction.DEPOSIT){
                System.out.printf("Giao dich 1: Nap tien $%.2f. So du luc nay: $%.2f\n", x.getAmount(), x.getBalance());
            }
            else if(x.getOperation() == Transaction.WITHDRAW){
                System.out.printf("Giao dich 2: Rut tien $%.2f. So du luc nay: $%.2f\n", x.getAmount(), x.getBalance());
            }
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
