import java.text.DecimalFormat;

public class InsufficientFundsException extends BankException{
    public InsufficientFundsException(double b) {
        super("Số dư tài khoản không đủ $"
                + new DecimalFormat("0.00").format(b)
                + "để thực hiện giao dịch");
    }
}
