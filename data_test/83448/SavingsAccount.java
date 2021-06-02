public class SavingsAccount extends Account {

    /**
     * create an instance.
     */
    public SavingsAccount() {
        typeAccountToInt = 2;
    }

    /**
     * create an instance.
     */
    public SavingsAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        typeAccountToInt = 2;
    }

    @Override
    public void deposit(double b) {
        try {
            doDepositing(b);
        } catch (InvalidFundingAmountException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void withdraw(double b) {
        if (b > 1000 || getBalance() < 5000) {
            return;
        }
        try {
            doWithdrawing(b);
        } catch (InvalidFundingAmountException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
