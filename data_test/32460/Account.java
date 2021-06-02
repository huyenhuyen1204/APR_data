import java.util.ArrayList;

public class Account {
    private double balance; // số dư tài khoản ngân hàng

    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>() ;

    private String deposit() {
        return null;
    }; // tiền gửi

    private String withdraw() {
        return null;
    } // rút tiền

    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            this.balance += amount;
        }
    }

    private void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if(amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if(operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction dep = new Transaction(operation, amount, this.balance);
            transitionList.add(dep);
        } else if(operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction wit = new Transaction(operation, amount, this.balance);
            transitionList.add(wit);
        } else System.out.println("Yeu cau khong hop le!");
    }

    public void printTransaction() {
        for (int i=0; i<transitionList.size(); i++) {
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",i+1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",i+1 , transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
            }
        }
    }

    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000.00,"withdraw");
        acc.printTransaction();
    }
}
