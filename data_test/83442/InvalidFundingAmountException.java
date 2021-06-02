public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double b) {
        this.mess = "Số tiền không hợp lệ: $" + b;
    }
}
