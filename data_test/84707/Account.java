import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }

    }

    ;

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount >= balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    ;

    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.DEPOSITE)) {

            deposit(amount);
            Transaction c = new Transaction(operation, amount, balance);
            transitionList.add(c);


        } else if (operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction c = new Transaction(operation, amount, balance);
            transitionList.add(c);

        } else {
            System.out.println("Yeu cau khong hop le!");
        }

    }

    ;

    /**
     * Lich su giao dich.
     */
    public void printTransaction() {

        for (int i = 0; i < transitionList.size(); i++) {
            String c = "";
            if (transitionList.get(i).getOperation().equalsIgnoreCase(Transaction.DEPOSITE)) {
                c = "Nap tien";
            } else {
                c = "Rut tien";
            }
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n", i + 1, c,
                    transitionList.get(i).getAmount(), (double) Math.round(balance * 100) / 100);
        }

    }

}
