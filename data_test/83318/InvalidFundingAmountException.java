public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double money) {
        super("Số tiền không hợp lệ: $" + money);
    }
}
