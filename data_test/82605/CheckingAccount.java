/**
 * Created by CCNE on 02/12/2020.
 */
public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (InvalidFundingAmountException | InsufficientFundsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
