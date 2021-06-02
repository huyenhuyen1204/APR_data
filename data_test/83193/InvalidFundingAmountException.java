/**
 * Created by CCNE on 03/12/2020.
 */
public class InvalidFundingAmountException extends BankException {
    /**
     * javadoc.
     */
    public InvalidFundingAmountException(double number) {
        super(String.format("Số tiền không hợp lệ: $%.2f", number));
    }
}
 