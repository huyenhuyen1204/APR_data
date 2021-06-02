import java.util.ArrayList;

public class Account {
    private double balance;
    ArrayList<Transaction> arrayList = new ArrayList<>();
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }
    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0) {
            balance -= amount;
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
    }

    void addTransaction(double amount, String operation) {
        if (operation.equals("gui")) {
            deposit(amount);
            Transaction guiTien = new Transaction(operation, amount, this.balance);
            arrayList.add(guiTien);
        } else if (operation.equals("rut")) {
            withdraw(amount);
            Transaction rutTien = new Transaction(operation, amount, this.balance);
            arrayList.add(rutTien);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i<arrayList.size(); i++) {
            System.out.println("Giao dich"+ (i + 1) + ":" + arrayList.get(i).toString());
        }
    }
}
