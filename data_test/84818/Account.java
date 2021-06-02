import java.util.ArrayList;

public class Account {

    private double balance;
    ArrayList<Transaction> listTrans = new ArrayList<>();

    /**
     * Nap tien.
     */
    private void deposit(double amount){
        if (amount < 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        balance += amount;
        listTrans.add(new Transaction("deposit",amount,balance));
    }

    /**
     * Rut tien.
     */
    private void withdraw(double amount){
        if (amount < 0){
            System.out.println("So tien ban nap vao khong hop le!");
        }
        if (amount > balance){
            System.out.println("So tien ban rut vuot qua so du!");
        }
        balance -= amount;
        listTrans.add(new Transaction("withdraw",amount,balance));
    }

    /**
     * Thuc hien giao dich.
     */
    public void addTransaction(double amount, String operation){
        if (operation == "deposit"){
            deposit(amount);
        }
        if (operation == "withdraw"){
            withdraw(amount);
        }
        else System.out.println("Yeu cau khong hop le!");
    }

    /**
     * In ra giao dich.
     */
    public void printTransaction() {
        for (int i = 0; i < listTrans.size(); i++) {
            System.out.print("Giao dich " + ( i + 1 ) + " ");
            if (listTrans.get(i).getOperation().equals("deposit")){
                System.out.print("Nap tien ");
            }
            if (listTrans.get(i).getOperation().equals("withdraw")){
                System.out.print("Rut tien ");
            }
            System.out.printf("$%.2f", listTrans.get(i).getAmount());
            System.out.print(" So du luc nay: ");
            System.out.printf("$%.2f\n", listTrans.get(i).getBalance());
        }
    }
}
