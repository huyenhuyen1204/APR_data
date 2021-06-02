public class SavingsAccount extends Account {
    /**
     * Constructor.
     */
    public SavingsAccount(long accountNumber, double balance) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    /**
     * Deposit for saving account.
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
     * Withdraw for saving account.
     */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new InvalidFundingAmountException(amount);
            }
            if (this.getBalance() < 5000) {
                throw new InsufficientFundsException(amount);
            }
            doWithdrawing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
