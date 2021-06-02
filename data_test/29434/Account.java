import java.util.ArrayList;

public class Account {
    private double balance;
    public ArrayList<Transaction> list = new ArrayList<Transaction>();
    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else balance+=amount;
    }
    private void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        else if(amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else balance-=amount;
    }
    public void addTransaction(double amount, String operation) {
        if(!operation.equals("withdraw") && !operation.equals("deposit")) {
            System.out.println("Yeu cau khong hop le!");
        }
        else {
            if(operation.equals("deposit")) balance+=amount;
            else if(operation.equals("withdraw")) balance-=amount;
            Transaction add = new Transaction(operation,amount,balance);
            list.add(add);
        }
    }
    public void  printTransaction() {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getOperation() == "deposit") {
                System.out.println("Giao dich " + (i + 1) + ": Nap tien $" + (double) Math.round(list.get(i).getAmount()*100)/100 + ". So du luc nay: $" + (double) Math.round((list.get(i).getBalance()) * 100) / 100);
            } else if (list.get(i).getOperation() == "withdraw") {
                System.out.println("Giao dich " + (i + 1) + ": Rut tien $" + (double) Math.round(list.get(i).getAmount()*100)/100+ ". So du luc nay: $" + (double) Math.round(list.get(i).getBalance() * 100) / 100);
            }
        }
    }
    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000.000,"withdraw");
        acc.printTransaction();
    }
}
