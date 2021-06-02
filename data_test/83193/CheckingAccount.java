/**
 * Created by CCNE on 03/12/2020.
 */
public class CheckingAccount extends Account {
    /**
     * javadoc.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * javadoc.
     */
    public void withdraw(double number) {
        try {
            double cur = this.getBalance();
            doWithdrawing(number);
            addTransaction(new Transaction(-1, number, cur, this.getBalance()));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * javadoc.
     */
    public void deposit(double number) {
        try {
            double cur = this.getBalance();
            doDepositing(number);
            addTransaction(new Transaction(1, number, cur, this.getBalance()));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
 