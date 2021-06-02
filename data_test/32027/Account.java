import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private void deposit(double amount){
        if (amount < 0 ){
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        this.balance += amount;
    }
    private void withdraw(double amount){
        if (amount < 0 ){
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > this.balance ){
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        this.balance -= amount;
    }
    public void addTransaction(double amount , String operation){
        if (operation != "DEPOSIT" || operation != "deposit" || operation != "withdraw"|| operation!= "WITHDRAW"){
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if (operation == "DEPOSIT" || operation == "deposit"){
            this.deposit(amount);
            Transaction a = new Transaction("deposit", amount, balance);
            transitionList.add(a);
            return;
        }
        if (operation == "WITHDRAW" || operation == "withdraw"){
            this.withdraw(amount);
            Transaction b = new Transaction("deposit", amount, balance);
            transitionList.add(b);
            return;
        }
    }
    public void printTransaction(){
        for (int i =0;i<transitionList.size();i++){
            System.out.println("Giao dich " + (i+1) + ":");
            if (transitionList.get(i).getOperation() == "deposit"){
            System.out.print(" Nap tien $" + transitionList.get(i).getAmount() + ". So du luc nay: $" + transitionList.get(i).getBalance());
            }
            if (transitionList.get(i).getOperation() == "withdraw"){
                System.out.print("Rut tien $" + transitionList.get(i).getAmount() + ". So du luc nay: $" + transitionList.get(i).getBalance());
            }
        }
    }
}
