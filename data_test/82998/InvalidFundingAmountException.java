public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(String message) {
        super(message);
    }

    public InvalidFundingAmountException(double amount) {
        super("Số dư tài khoản không đủ $" + amount + " để thực hiện giao dịch");
    }
}
