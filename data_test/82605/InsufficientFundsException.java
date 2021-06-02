import java.text.DecimalFormat;

/**
 * Created by CCNE on 02/12/2020.
 */
public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double amount) {
        super("Số dư tài khoản không đủ $" + new DecimalFormat("##.##").format(amount) + " để thực hiện giao dịch");
    }
}
