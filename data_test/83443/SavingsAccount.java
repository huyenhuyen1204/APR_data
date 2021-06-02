public class SavingsAccount extends Account {

    public SavingsAccount() {
        typeAccountToInt = 2;
        maxWithdraw = 1000;
        minBalance = 5000;
    }

    public SavingsAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        typeAccountToInt = 2;
        maxWithdraw = 1000;
        minBalance = 5000;
    }

    @Override
    public void deposit(double b) {
        try {
            doDepositing(b);
        }
        catch(BankException ex) {
            System.out.println(ex.getMess());
        }
    }

    @Override
    public void withdraw(double b) {
        try {
            doWithdrawing(b);
        }
        catch(BankException ex) {
            System.out.println(ex.getMess());
        }
    }
}
