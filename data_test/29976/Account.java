import java.util.ArrayList;

public class Account {

    private double balance = 0; // số dư tài khoản ngân hàng
    private ArrayList<Transaction> transitionList;
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
                    System.out.println("Giao dich " + i + ": " + "Nap tien $" + Math.round(transitionList.get(i).getAmount() * 100) / 100 +
                            ". So du luc nay: " + "$" + Math.round(transitionList.get(i).getBalance() * 100) / 100);
                }
                else{
                    System.out.println("Giao dich " + i + ": " + "Rut tien $" + Math.round(transitionList.get(i).getAmount() * 100) / 100 +
                            ". So du luc nay: " + "$" + Math.round(transitionList.get(i).getBalance() * 100) / 100);
                }
            }
        }
    }

    public static void main(String[] args){

    }
}
