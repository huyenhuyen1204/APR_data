//package banking;

public class CheckingAccount extends Account {
    public CheckingAccount(Long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double d) {
        try {
            doWithdrawing(d);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
                    d, getBalance() + d, getBalance()));
        } catch (BankException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void deposit(double d) {
        try {
            doDepositing(d);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                    d, getBalance() - d, getBalance()));

        } catch (BankException e) {
            System.out.println(e.toString());
        }

    }
}
