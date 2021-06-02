/**
 * Created by CCNE on 03/12/2020.
 */
public class InvalidFundingAmountException extends BankException {
    /**
     * Functions.
     */
    public InvalidFundingAmountException(double money) {
        super("Số tiền không hợp lệ: $" + String.format("%.2f", money));
    }
}
