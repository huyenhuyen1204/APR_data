//package banking;

public class InsufficientFundsException extends BankException {

    /**
     * exception so du tai khoan ko du.
     */
    public InsufficientFundsException(double d) {
        super("Số dư tài khoản không đủ $"
                + String.format("%.2f", d)
                + " để thực hiện giao dịch");
    }
}
