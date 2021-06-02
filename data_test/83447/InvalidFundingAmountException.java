import java.text.DecimalFormat;

public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double b) {
        super("Số tiền không hợp lệ: $"
                + new DecimalFormat("0.00").format(b));

    }
}
