public class SavingsAccount extends Account {

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      if (amount > 1000) {
        throw new InvalidFundingAmountException(amount);
      }
      if (initialBalance < 5000) {
        throw new InsufficientFundsException(initialBalance);
      }
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
