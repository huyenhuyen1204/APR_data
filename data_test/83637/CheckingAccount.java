public class CheckingAccount extends Account {
    /**
     * Constructor.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Override withdraw.
     */
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }

    /**
     * Override deposit.
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }
}