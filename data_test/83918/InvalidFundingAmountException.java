public class InvalidFundingAmountException extends BankException {
    InvalidFundingAmountException(double x) {
        super(String.format("Số tiền không hợp lệ: $%.2f\n",x));
    }
}
