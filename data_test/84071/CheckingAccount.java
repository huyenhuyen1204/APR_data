/**
 * class CheckingAccount.
 */
public class CheckingAccount extends Account {

    /**
     * constructor.
     * @param accountNumber .
     * @param balance .
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * withdraw.
     * @param amount .
     */
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
                    amount, balance, balance - amount));
            balance -= amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
        }
    }

    /**
     * deposit.
     * @param amount .
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                    amount, balance, balance + amount));
            balance += amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
        }
    }
}
