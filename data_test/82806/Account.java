import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList;

    /*Chong chong tre ne Nobita.*/
    public Account() {
        transactionList = new ArrayList<>();
    }

    /*Chong chong tre ne Nobita.*/
    private void deposit(double amount) {
        if (amount == 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        transactionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }

    /*Chong chong tre ne Nobita.*/
    private void withdraw(double amount) {
        if (amount == 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        transactionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }

    /*Chong chong tre ne Nobita.*/
    public void addTransaction(double amount, String operation) {
        switch (operation) {
            case Transaction.DEPOSIT:
                deposit(amount);
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }

    /*Chong chong tre ne Nobita.*/
    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction temp = transactionList.get(i);
            String out = "Giao dich " + String.valueOf(i + 1) + ": ";
            switch (temp.getOperation()) {
                case Transaction.DEPOSIT:
                    out += "Nap tien $";
                    break;
                case Transaction.WITHDRAW:
                    out += "Rut tien $";
                    break;
                default:
                    break;
            }
            out += String.format("%.2f", temp.getAmount());
            out += ". So du luc nay: $";
            out += String.format("%.2f", temp.getBalance());
            out += ".\n";
            System.out.print(out);
        }
    }
}
