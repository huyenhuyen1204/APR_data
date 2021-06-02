import java.text.DecimalFormat;

public class InsufficientFundsException extends BankException {
    /**
     * Constructor.
     */
    public InsufficientFundsException(double money) {
        super("Số dư tài khoản không đủ $" + (new DecimalFormat("0.00")).format(money) + " để thực hiện giao dịch");
    }
}
