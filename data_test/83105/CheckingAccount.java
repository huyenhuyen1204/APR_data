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
            double initialBalance = balance;
            doWithdrawing(amount);
            addTransaction(
                new Transaction(
                    Transaction.TYPE_WITHDRAW_CHECKING,
                    amount, initialBalance, balance));
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
            double initialBalance = balance;
            doDepositing(amount);
            addTransaction(
                new Transaction(
                    Transaction.TYPE_DEPOSIT_CHECKING,
                    amount, initialBalance, balance));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}

