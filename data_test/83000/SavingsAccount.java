public class SavingsAccount extends Account {
  public SavingsAccount(long accountNumber, double balance) {
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
      if (balance < 5000.0) {
        throw new InsufficientFundsException(5000.0);
      }
      if (money > 1000.0) {
        throw new InvalidFundingAmountException(money);
      }
      double initialMoney = balance;
      doWithdrawing(money);
      addTransaction(
              new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, money, initialMoney, balance));
    } catch (BankException exception) {
      System.out.println(exception);
    }
  }
}
