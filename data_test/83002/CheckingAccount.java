public class CheckingAccount extends Account {
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double money) {
    try {
      double initialMoney = balance;
      doDepositing(money);
      addTransaction(
              new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, money, initialMoney, balance));
    } catch (BankException exception) {
      System.out.println(exception);
    }
  }

  @Override
  public void withdraw(double money) {
    try {
      double initialMoney = balance;
      doWithdrawing(money);
      addTransaction(
              new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, money, initialMoney, balance));
    } catch (BankException exception) {
      System.out.println(exception);
    }
  }
}
