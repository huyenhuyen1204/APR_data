import java.text.DecimalFormat;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double x) {
        super("Số dư tài khoản không đủ $"
                + (new DecimalFormat("0.00")).format(x) + " để thực hiện giao dịch");
    }
}
