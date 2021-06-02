public class InsufficientFundsException extends BankException {
    InsufficientFundsException(double x) {
        super(String.format("Số dư tài khoản không đủ $%.2f để thực hiện giao dịch\n", x));
    }
}
