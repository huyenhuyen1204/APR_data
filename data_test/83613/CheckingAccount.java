/**
 * Created by CCNE on 03/12/2020.
 */
public class CheckingAccount extends Account {
    /**
     * Functions.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Functions.
     */
    @Override
    public void withdraw(double money) {
        try {
            doWithdrawing(money);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
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
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                    money, getBalance() - money, getBalance()));

        } catch (BankException e) {
            System.out.println(e.toString());
        }

    }
}
