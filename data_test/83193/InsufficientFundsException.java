/**
 * Created by CCNE on 03/12/2020.
 */
public class InsufficientFundsException extends BankException {
    /**
     * javadoc.
     */
    public InsufficientFundsException(double number) {
        super(String.format("Số dư tài khoản không đủ $%.2f để thực hiện giao dịch", number));
    }
} 