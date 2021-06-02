public class CheckingAccount extends Account {

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
    } catch (BankException e) {
      System.out.println(e.toString());
    }
    addTransaction(
        new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, getBalance())
    );
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
    } catch (BankException e) {
      System.out.println(e.toString());
    }
    addTransaction(
        new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, getBalance())
    );
  }
}
