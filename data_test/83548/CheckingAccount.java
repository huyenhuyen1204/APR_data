public class CheckingAccount extends Account {

    /**
     * Yes.
     */
    public CheckingAccount(long a, double b) {
        super(a, b);
    }

    /**
     * Yes.
     */
    public void withdraw(double x) {
        try {
            doWithdrawing(x);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }

    /**
     * Yes.
     */
    public void deposit(double x) {
        try {
            doDepositing(x);
        } catch (BankException e) {
            e.printStackTrace();
        }
    }
}
 