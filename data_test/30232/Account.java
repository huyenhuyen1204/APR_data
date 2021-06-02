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
        for(int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (int)(i + 1) + ": " );
            if(transitionList.get(i).getOperation() == Transaction.DEPOSIT) {
                System.out.printf("Nap tien $%d. So du luc nay: $%d.%n",(Math.round(transitionList.get(i).getAmount() * 100.00) / 100.00), (Math.round(transitionList.get(i).getBalance() * 100.00) / 100.00));
            } else {
                System.out.printf("Rut tien $%d. So du luc nay: $%d.%n",(Math.round(transitionList.get(i).getAmount() * 100.00) / 100.00), (Math.round(transitionList.get(i).getBalance() * 100.00) / 100.00));
            }
        }
    }
}
