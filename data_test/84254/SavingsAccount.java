/**
 * class SavingsAccount.
 */
public class SavingsAccount extends Account {

    /**
     * constructor.
     * @param accountNumber .
     * @param balance .
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * withdraw.
     * @param amount .
     */
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount, balance, balance - amount));
            balance -= amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
        }
    }

    /**
     * deposit .
     * @param amount .
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, balance, balance + amount));
            balance += amount;
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
        }
    }
}
