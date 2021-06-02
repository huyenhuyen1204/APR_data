import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transitionList = new ArrayList<>();

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
            transitionList.add(new Transaction("deposit", amount, balance));
        }

        if(operation.equals("withdraw")) {
            widthdraw(amount);
            transitionList.add(new Transaction("withdraw", amount, balance));
        }
    }

    public void printTransaction() {
        String s;
        for(int i=0; i<transitionList.size(); i++) {
            if(transitionList.get(i).getOperation().equals("deposit")) {
                s = "Nap tien $";
            }
            else s = "Rut tien $";
            System.out.print(String.format("Giao dich %d: %s%.2f. So du luc nay: $%.2f.", (i+1), s, transitionList.get(i).getAmount(), transitionList.get(i).getBalance()));
            System.out.println();
        }
    }
}
