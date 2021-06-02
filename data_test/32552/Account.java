import java.util.ArrayList;

public class Account {
    private double balance = 0;  //Thuộc tính thông tin về số dư tài khoản ngân hàng balance, có kiểu là double

    //Một danh sách các giao dịch (sử dụng ArrayList) để theo dõi các thao tác nạp tiền, rút tiền ( vì lịch sử giao dịch chỉ được sử dụng ở phương thức printTransaction()).
    private ArrayList<Transaction> transitionList;

    public Account() {
        transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount > 0){
            this.balance = this.balance + amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, this.balance));
        }
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        }     else {
            this.balance = this.balance - amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, this.balance));
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }


    public void printTransaction() {
        this.balance = Math.round(getBalance() * 100.0) / 100.0;

        for (int i = 0; i < transitionList.size(); i++) {
            double gd1 = Math.round(transitionList.get(i).getBalance() * 100.0) / 100.0;
            double du1 = Math.round(transitionList.get(i).getAmount() * 100.0) / 100.0;

            double gd2 = Math.round(transitionList.get(i).getBalance());
            double du2 = Math.round(transitionList.get(i).getAmount());

            String balance = String.valueOf((gd1 == gd2) ? gd2 + "0" : gd1);
            String amount = String.valueOf((du1 == du2) ? du2 + "0" : du1);

            if(transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)){
                System.out.println("Giao dich " + (i+1) +": Nap tien $" + amount + ". So du luc nay: $" + balance + ".");
            }else if(transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)){
                System.out.println("Giao dich " + (i+1) +": Rut tien $" + amount + ". So du luc nay: $" + balance + ".");
            }
        }
    }

    public double getBalance() {
        return balance;
    }


}
