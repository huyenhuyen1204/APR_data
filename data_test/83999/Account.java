import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<Transaction>();

    /**
     * control.
     */
    public Account() {
    }

    /**
     * control.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * control.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * control.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * control.
     */
    public abstract void deposit(double money);

    /**
     * control.
     */
    public abstract void withdraw(double money);

    /**
     * control.
     */
    public void doDepositing(double money) throws BankException {
        if (money < 0) {
            throw new InvalidFundingAmountException(money);
        }
        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, money,
                    balance, balance + money);
        } else {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, money,
                    balance, balance + money);
        }
        transactionList.add(transaction);
        balance += money;
    }

    /**
     * control.
     */
    public void doWithdrawing(double money) throws BankException {
        if (money < 0) {
            throw new InvalidFundingAmountException(money);
        } else if (money > balance) {
            throw new InsufficientFundsException(money);
        }
        if (this instanceof SavingsAccount) {
            if (money > 1000) {
                throw new InvalidFundingAmountException(money);
            } else if (balance - money < 5000) {
                throw new InsufficientFundsException(money);
            }
        }
        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, money,
                    balance, balance - money);
        } else {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, money,
                    balance, balance - money);
        }
        transactionList.add(transaction);
        balance -= money;
    }

    /**
     * control.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * control.
     */
    public String getTransactionHistory() {
        String res;
        res = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (int i = 0; i < transactionList.size(); ++ i) {
            res = res + "\n" + transactionList.get(i).getTransactionSummary();
        }

        return res;
    }

    /**
     * control.
     */
    public boolean equals(Object o) {
        if (this.accountNumber == ((Account) o).accountNumber) {
            return true;
        }
        return false;
    }
}
