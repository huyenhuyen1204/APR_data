import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 03/12/2020.
 */
public abstract class Account {
  public static final String CHECKING = "CHECKING";
  public static final String SAVINGS = "SAVINGS";
  protected long accountNumber;
  protected double balance;
  protected List<Transaction> transactionList;

  /**
   * A.
   */
  public Account() {
    transactionList = new ArrayList<>();
  }

  /**
   * A.
   *
   * @param accountNumber a
   * @param balance       b
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    transactionList = new ArrayList<>();
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public abstract void deposit(double money);

  public abstract void withdraw(double money);

  /**
   * A.
   *
   * @param money a
   * @throws BankException b
   */
  public void doWithdrawing(double money) throws BankException {
    if (money < 0) {
      throw new InvalidFundingAmountException(money);
    } else if (money > balance) {
      throw new InsufficientFundsException(money);
    } else {
      balance -= money;
    }
  }


  /**
   * Dep.
   *
   * @param money m
   * @throws BankException e
   */
  public void doDepositing(double money) throws BankException {
    if (money < 0) {
      throw new InvalidFundingAmountException(money);
    } else {
      balance += money;
    }
  }

  /**
   * Get transaction history.
   *
   * @return history
   */
  public String getTransactionHistory() {
    StringBuilder res = new StringBuilder(
            String.format("Lịch sử giao dịch của tài khoản %d:\n", accountNumber));
    for (Transaction transaction : transactionList) {
      res.append(transaction.getTransactionSummary()).append('\n');
    }
    return res.toString().trim();
  }

  public void addTransaction(Transaction transaction) {
    transactionList.add(transaction);
  }

  /**
   * Compare id.
   *
   * @param obj other
   * @return equals or not
   */
  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Account
            && ((Account) obj).accountNumber == this.accountNumber);
  }
}
