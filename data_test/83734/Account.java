//package imyourjoy.transaction;

import java.util.ArrayList;

public class Account {
  private double balance;
  private ArrayList<Transaction> list = new ArrayList<>();

  private void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    } else {
      System.out.println("So tien ban nap vao khong hop le!");
    }
  }

  private  void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    } else if (amount < 0) {
      System.out.println("So tien ban rut ra khong hop le!");
    } else if (amount > balance) {
      System.out.println("So tien ban rut vuot qua so du!");
    }
  }

  /**
   * addTransaction.
   */
  public void addTransaction(double amount, String operation) {
    double b = balance;
    if (operation.equals(Transaction.DEPOSIT)) {
      deposit(amount);
      if (balance != b) {
        Transaction transaction = new Transaction(operation, amount, balance);
        list.add(transaction);
      }
    } else if (operation.equals(Transaction.WITHDRAW)) {
      withdraw(amount);
      if (balance != b) {
        Transaction transaction = new Transaction(operation, amount, balance);
        list.add(transaction);
      }
    } else {
      System.out.println("Yeu cau khong hop le!");
    }
  }

  /**
   * printTransaction.
   */
  public void printTransaction() {
    for (int i = 0; i < list.size(); i++) {
      String str = "";
      if (list.get(i).getOperation().equals(Transaction.DEPOSIT)) {
        str = "Nap tien";
      } else {
        str = "Rut tien";
      }
      System.out.println("Giao dich " + (i + 1) + ": " + str + " $"
          + round(list.get(i).getAmount()) + ". So du luc nay: $"
          + round(list.get(i).getBalance()) + ".");
    }
  }

  private String round(double number) {
    String str = "";
    double number1 = (double) Math.round(number * 100) / 100;

    if (number - (int) number == 0) {
      str = String.valueOf((int) number) + ".00";
    } else {
      str = String.valueOf(number1);
    }
    return str;
  }

  /*public static void main(String[] args) {
    Account acc = new Account();
    acc.addTransaction(2000.255,"deposit");
    acc.addTransaction(1000,"withdraw");
    acc.printTransaction();
  }*/

}
