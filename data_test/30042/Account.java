import java.util.ArrayList;

public class Account {

    private double balance = 0; // số dư tài khoản ngân hàng
    private ArrayList<Transaction> transitionList = new ArrayList<>();
    private void deposit(double amount){  // gửi tiền
        if(amount <= 0)
            System.out.println("So tien ban nap vao khong hop le!");
        else {
            balance += amount;
            transitionList.add(new Transaction("deposit", amount, balance));
        }
    }
    private void withdraw(double amount){  // rút tiền
        if(amount <= 0)
            System.out.println("So tien ban rut ra khong hop le!");
        else if(amount > balance)
            System.out.println("So tien ban rut vuot qua so du!");
        else {
            balance -= amount;
            transitionList.add(new Transaction("withdraw", amount, balance));
        }
    }

    public void addTransaction(double amount, String operation){
        if(!operation.equals(Transaction.DEPOSIT) && !operation.equals(Transaction.WITHDRAW)){
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if(operation.equals(Transaction.DEPOSIT)){
            deposit(amount);
        }
        else{
            withdraw(amount);
        }
    }

    public void printTransaction(){
        if(!transitionList.isEmpty()){
            for(int i=0; i<transitionList.size(); i++){
                if(transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)){
                    System.out.println("Giao dich " + (i + 1) + ": " + "Nap tien $" + String.format("%.2f", transitionList.get(i).getAmount()) +
                            ". So du luc nay: " + "$" + String.format("%.2f", transitionList.get(i).getBalance())  + ".");
                }
                else{
                    System.out.println("Giao dich " + (i + 1) + ": " + "Rut tien $" + String.format("%.2f", transitionList.get(i).getAmount()) +
                            ". So du luc nay: " + "$" + String.format("%.2f", transitionList.get(i).getBalance())  + ".");
                }
            }
        }
    }
/*
    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
*/

}
