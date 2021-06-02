
/**
 * Created by CCNE on 03/12/2020.
 */
public class SavingsAccount extends Account {
    /**
     * javadoc.
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * javadoc.
     */
    public void withdraw(double number) {
        try {
            if (number > 1000 || this.getBalance() - number < 5000) {
                throw new InvalidFundingAmountException(number);
            } else {
                double cur = this.getBalance();
                doWithdrawing(number);
                addTransaction(new Transaction(-2, number, cur, this.getBalance()));
            }
        } catch (Exception e) {
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
            addTransaction(new Transaction(2, number, cur, this.getBalance()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
 