public class InvalidFundingAmountException extends BankException {
    /**
     * Constructor.
     */
    public InvalidFundingAmountException(double amount) {
        super(String.format("Số tiền không hợp lệ: $%.2f", amount));
    }
}
