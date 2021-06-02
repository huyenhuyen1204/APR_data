public class CheckingAccount extends Account {

    public CheckingAccount() {
        accountNumber = 0;
        balance = 0;
    }

    public CheckingAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
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
        try {
            doWithdrawing(b);
        } catch (InvalidFundingAmountException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
