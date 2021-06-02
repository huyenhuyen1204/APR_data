/**
 * class InvalidFundingAmountException.
 */
public class InvalidFundingAmountException extends BankException {

    /**
     * constructor.
     */
    public InvalidFundingAmountException(double amount) {
        super("Số tiền không hợp lệ: $"
                + String.format("%.2f",amount));
    }
}
