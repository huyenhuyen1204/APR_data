/**
 * Created by CCNE on 02/12/2020.
 */
public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new InvalidFundingAmountException(amount);
            }
            double oldBalance = balance;
            doWithdrawing(amount);
            if (balance < 5000) {
                balance = oldBalance;
                throw new InsufficientFundsException(amount);
            }
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount, oldBalance, balance));
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            double oldBalance = balance;
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, oldBalance, balance));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
 