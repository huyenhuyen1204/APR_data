import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {

  public static final String CHECKING = "CHECKING";
  public static final String SAVINGS = "SAVINGS";

  private final long accountNumber;
  private double balance;
  protected final List<Transaction> transactionList;

  /**
   * xyz.
   * @param accountNumber xzy
   * @param balance xyz
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    transactionList = new ArrayList<>();
  }

  /**
   * xyz.
   */
  public Account() {
    this(0, 0);
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public abstract void withdraw(double amount);

  public abstract void deposit(double amount);

  /**
   * xyz.
   * @param amount xzy
   * @throws BankException xdkj
   */
  public void doDepositing(double amount) throws BankException {
    if (amount < 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  /**
   * dkjaldf.
   * @param amount ddf
   * @throws BankException ddd
   */
  public void doWithdrawing(double amount) throws BankException {
    if (amount < 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  public void addTransaction(Transaction transaction) {
    transactionList.add(transaction);
  }

  /**
   * kldfjlaskdjfdlk.
   * @return asdlkfjsadkl
   */
  public String getTransactionHistory() {
    StringBuilder builder = new StringBuilder("Lịch sử giao dịch của tài khoản ")
        .append(accountNumber).append(":\n");
    for (Transaction t : transactionList) {
      builder.append(t.getTransactionSummary()).append('\n');
    }
    builder.deleteCharAt(builder.length() - 1);
    return builder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return accountNumber == account.accountNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber);
  }
}
