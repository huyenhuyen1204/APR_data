import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transactionsList = new ArrayList<>();

    private void deposit(double amount) {
        if(amount <= 0) {
            System.out.print("So tien ban nap vao khong hop le!");
            return;
        }
        balance +=amount;
    }

    private void widthdraw(double amount) {
        if(amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if(amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -=amount;
    }

    public void addTransaction(double amount, String operation) {
        if(!operation.equals("deposit") && !operation.equals("withdraw")) {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
        if(operation.equals("deposit")) {
            deposit(amount);
            transactionsList.add(new Transaction(operation, amount, balance));
        }

        if(operation.equals("withdraw")) {
            widthdraw(amount);
            transactionsList.add(new Transaction(operation, amount, balance));
        }
    }

    public void printTransaction() {
        String s;
        for(int i=0; i<transactionsList.size(); i++) {
            if(transactionsList.get(i).getOperation().equals("deposit")) {
                s = "Nap tien $";
            }
            else s = "Rut tien $";
            System.out.print(String.format("Giao dich %d: %s%.2f. So du luc nay: $%.2f.", (i+1), s, transactionsList.get(i).getAmount(), transactionsList.get(i).getBalance()));
            System.out.println();
        }
    }
}
