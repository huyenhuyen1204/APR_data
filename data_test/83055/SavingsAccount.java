//package banking;

public class SavingsAccount extends Account {
    public SavingsAccount(Long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    //check lai theo yeu cau
    @Override
    public void withdraw(double d) {
        if (d > 1000 || getBalance() < 5000) {
            return;
        }
        try {

            doWithdrawing(d);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    d, getBalance()+d, getBalance()));

        } catch (BankException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void deposit(double d) {
        try {
            doDepositing(d);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    d, getBalance()-d, getBalance()));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.toString());
        }


    }
}
