import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;
    public Account() {
        transitionList = new ArrayList<Transaction>();
    }

    private void deposit (double amount) {
        if(amount<=0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        else
            balance+=amount;
    }
    private void withdraw(double amount) {
        if(amount<=0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        else if(amount>balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        else balance-=amount;
    }
    public void addTransaction(double amount,String operation) {
        if(operation.equals("deposit"))
        {
            deposit(amount);
            Transaction temp = new Transaction("deposit", amount, balance);
            transitionList.add(temp);
        }
        else if(operation.equals("withdraw"))
        {
            {
                withdraw(amount);
                Transaction temp = new Transaction("withdraw", amount, balance);
                transitionList.add(temp);
            }
        }
        else
        {
            System.out.println("Yeu cau khong hop le!");
        }

    }
    public void printTransaction() {
        String t ;
        for (int i = 0; i< transitionList.size(); i++) {
            if(transitionList.get(i).getOperation().equals("deposit")) {
                t = "Nap tien $";
            }
             else
                 t= "Rut tien $";
             System.out.println(String.format("Giao dich %d: %s%.2f. So du luc nay: $%.2f.",i+1, t , transitionList.get(i).getAmount(), transitionList.get(i).getBalance()));
            }
        }

    }


