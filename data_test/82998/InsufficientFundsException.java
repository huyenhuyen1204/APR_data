public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(double amount) {
        super("Số tiền không hợp lệ: $" + amount);
    }
}
