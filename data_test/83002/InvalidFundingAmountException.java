public class InvalidFundingAmountException extends BankException {
  public InvalidFundingAmountException(double money) {
    super(String.format("Số tiền không hợp lệ: $%.2f", money));
  }
}
