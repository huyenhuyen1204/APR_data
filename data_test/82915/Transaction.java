/**
 * Class representing a transaction.
 */
public class Transaction {

  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_DEPOSIT_SAVINGS = 2;
  public static final int TYPE_WITHDRAW_CHECKING = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  public final int type;
  public final double amount;
  public final double initialBalance;
  public final double finalBalance;

  /**
   * lkasjflksdjf.
   *
   * @param type           kdjk
   * @param amount         kdjk
   * @param initialBalance kdjk
   * @param finalBalance   kdjk
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /**
   * lksdjflkasjfklj.
   *
   * @param t dkfjk
   * @return lkdjflkaj
   */
  public String getTransactionTypeString(int t) {
    switch (t) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "";
    }
  }

  /**
   * kdjflksdjflk.
   *
   * @return kasjflsdak
   */
  public String getTransactionSummary() {
    return String
        .format("- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
            getTransactionTypeString(type),
            initialBalance, amount, finalBalance);
  }

  public boolean isWithdrawal() {
    return type == TYPE_WITHDRAW_CHECKING || type == TYPE_WITHDRAW_SAVINGS;
  }
}
