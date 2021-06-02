import java.text.DecimalFormat;

public class InvalidFundingAmountException extends BankException {
    /**
     * Constructor.
     */
    public InvalidFundingAmountException(double money) {
        super("Số tiền không hợp lệ: $" + (new DecimalFormat("0.00")).format(money));
    }
}
