/**
 * Created by CCNE on 02/12/2020.
 */
public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double amount) {
        super("So du tai khoan khong du " + amount + "de thuc hien giao dich");
    }
}
