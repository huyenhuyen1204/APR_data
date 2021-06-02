public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double money) {
        try {
            doWithdrawing(money);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(double money) {
        try {
            doDepositing(money);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }
}
