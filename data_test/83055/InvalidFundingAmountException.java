//package banking;

public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(Double amount) {
        super("Số tiền không hợp lệ: $" + String.format("%.2f", amount));
    }
}
