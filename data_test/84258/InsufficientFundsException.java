/**
 * class InsufficientFundsException.
 */
public class InsufficientFundsException extends BankException {

    /**
     * constructor.
     */
    public InsufficientFundsException(double amount) {
        super("Số dư tài khoản không đủ $"
                + String.format("%.2f", amount)
                + " để thực hiện giao dịch");
    }
}
