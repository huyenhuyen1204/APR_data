public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * control.
     */
    @Override
    public void withdraw(double money) {
        try {
            doWithdrawing(money);
        } catch (BankException bankException) {
            bankException.printStackTrace();
        }
    }

    /**
     * control.
     */
    @Override
    public void deposit(double money) {
        try {
            doDepositing(money);
        } catch (BankException bankException) {
            bankException.printStackTrace();
        }
    }
}
