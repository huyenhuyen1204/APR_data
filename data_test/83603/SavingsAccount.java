//package banking;

public class SavingsAccount extends Account {
    /**
     * Functions.
     */
    public SavingsAccount(Long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Functions.
     */
    @Override
    public void withdraw(double money) {
        if (money > 1000 || getBalance() < 5000) {
            return;
        }
        try {
            doWithdrawing(money);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    money, getBalance() + money, getBalance()));
        } catch (BankException e) {
            System.out.println(e.toString());
        }

    }

    /**
     * Functions.
     */
    @Override
    public void deposit(double money) {
        try {
            doDepositing(money);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    money, getBalance() - money, getBalance()));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.toString());
        }
    }
}
