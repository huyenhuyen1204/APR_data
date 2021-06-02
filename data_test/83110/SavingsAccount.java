public class SavingsAccount extends Account {

    private static final double minBalance = 5000;
    private static final double withdrawLimit = 1000;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw.
     */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount <= withdrawLimit && balance - amount >= minBalance) {
                double initialBalance = balance;
                doWithdrawing(amount);
                addTransaction(
                    new Transaction(
                        Transaction.TYPE_WITHDRAW_SAVINGS,
                        amount, initialBalance, balance));
            }
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
                    Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, initialBalance, balance));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
