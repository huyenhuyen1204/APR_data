public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    /**
     * Deposit for checking account.
     */
    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraw for checking account.
     */
    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
