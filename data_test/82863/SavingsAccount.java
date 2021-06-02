/**
 * Created by CCNE on 02/12/2020.
 */
public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < 5000) {
            System.out.println("Không đủ số dư tối thiểu");
            return;
        } else if (amount > 1000) {
            System.out.println("Vượt quá só tiền có thể rút");
            return;
        } else {
            try {
                doWithdrawing(amount);
                transactionList.add(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                        amount, balance + amount, balance));
            } catch (InvalidFundingAmountException | InsufficientFundsException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            transactionList.add(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, balance - amount, balance));
        } catch (InvalidFundingAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
 