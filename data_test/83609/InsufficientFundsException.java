/**
 * Created by CCNE on 03/12/2020.
 */
public class InsufficientFundsException extends BankException {
    /**
     * Functions.
     */
    public InsufficientFundsException(double money) {
        super("Số dư tài khoản không đủ $" + String.format("%.2f", money)
                + " để thực hiện giao dịch");
    }
}
