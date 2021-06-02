public class InsufficientFundsException extends BankException {

  public InsufficientFundsException(double amount) {
    super(String.format("Số dư tài khoản không đủ $%.2fđể thực hiện giao dịch", amount));
  }
}
