/**
 * Created by CCNE on 02/12/2020.
 */
public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double amount) {
        super("Số tiền không hợp lệ: " + String.format("$%.2f", amount));
    }
}
 