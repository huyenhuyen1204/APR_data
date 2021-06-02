import java.util.ArrayList;
/* amount: số tiền rút hoặc gửi
   balance: số dư
*/
public class Account  {
    private double balance; // thông tin về số dư tài khoản ngân hàng
    ArrayList <Transaction> TransactionList = new ArrayList<>();
    private Object operation;

    public Account(){};
    private void deposit(){}
    private void withdraw(){}

    public void deposit(double amount){
        if (amount <=0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else {
            amount= (double) Math.round(amount*100)/100;
            balance += amount;
            double other_balance = (double) Math.round(balance*100)/100;
            Transaction transaction = new Transaction("deposit",amount,other_balance);
            TransactionList.add(transaction);
        }
    }
    public void withdraw(double amount){
        if (amount<=0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        else if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        else {
            amount= (double) Math.round(amount*100)/100;
            balance-=amount;
            balance = (double) Math.round(balance*100)/100;
            Transaction transaction = new Transaction("withdraw",amount,balance);
            TransactionList.add(transaction);
        }
    }
    public  void addTransaction(double amount, String operation){
        if (!operation.equals(Transaction.DEPOSIT)&& !operation.equals(Transaction.WITHDRAW)){
            System.out.println("Yeu cau khong hop le!");
        }
        else if (operation.equals(Transaction.DEPOSIT)){
            deposit(amount);
        }
        else {
            withdraw(amount);
        }

    }
    public void printTransaction(){
        for (int i = 0; i< TransactionList.size();i++){
            System.out.print("Giao dich "+ (i+1) + ": ");
            if (!TransactionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.println("Nap tien $"+ TransactionList.get(i).getAmount() + ". So du luc nay: $"+TransactionList.get(i).getBalance()+".");
            }
            else if (!TransactionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                System.out.println("Rut tien $"+ TransactionList.get(i).getAmount() + ". So du luc nay: $"+TransactionList.get(i).getBalance()+".");
            }


        }
    }
    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }

}
