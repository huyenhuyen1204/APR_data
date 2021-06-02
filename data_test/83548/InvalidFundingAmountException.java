import java.text.DecimalFormat;

public class InvalidFundingAmountException extends BankException {

    /**
     * Yes.
     */
    public InvalidFundingAmountException(double x) {
        super("Số tiền không hợp lệ: $" + (new DecimalFormat("0.00")).format(x));
    }
}
 