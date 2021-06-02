//package banking;

public class InvalidFundingAmountException extends BankException {
    /**
     * exception so du tai khoan ko du.
     */
    public InvalidFundingAmountException(Double amount) {
        super("Số tiền không hợp lệ: $" + String.format("%.2f", amount));
    }
}
