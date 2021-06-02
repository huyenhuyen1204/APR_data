public class CheckingAccount extends Account {

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw.
     */
    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deposit.
     */
    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}

