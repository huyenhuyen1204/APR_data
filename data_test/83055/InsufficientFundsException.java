//package banking;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double d) {
        super("Số dư tài khoản không đủ $" +
                String.format("%.2f", d) +
                " để thực hiện giao dịch");
    }
}
