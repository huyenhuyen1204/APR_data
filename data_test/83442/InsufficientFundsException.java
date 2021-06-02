public class InsufficientFundsException extends BankException{
    public InsufficientFundsException(double b) {
        this.mess = "Số dư tài khoản không đủ $" + b +
                "để thực hiện giao dịch";
    }
}
