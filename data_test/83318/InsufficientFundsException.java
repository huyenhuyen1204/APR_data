public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double money) {
        super("Số dư tài khoản không đủ $" + money + " để thực hiện giao dịch");
    }
}
