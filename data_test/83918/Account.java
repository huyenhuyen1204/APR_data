import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {

    }

    /**
     * Javadoc.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Javadoc.
     */
    public void doWithdrawing(double x) throws BankException {
        if (x < 0) {
            throw new InvalidFundingAmountException(x);
        } else if (x > balance) {
            throw new InsufficientFundsException(x);
        }
        if (this instanceof SavingsAccount) {
            if (x > 1000) {
                throw new InvalidFundingAmountException(x);
            } else if (balance - x < 5000) {
                throw new InsufficientFundsException(x);
            }
        }
        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, x, balance, balance - x);
        } else {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, x, balance, balance - x);
        }
        transactionList.add(transaction);
        balance -= x;
    }

    /**
     * Javadoc.
     */
    public void doDepositing(double x) throws BankException {
        if (x < 0) {
            throw new InvalidFundingAmountException(x);
        }
        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, x, balance, balance + x);
        } else {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, x, balance, balance + x);
        }
        transactionList.add(transaction);
        balance += x;
    }

    public abstract void withdraw(double money);

    public abstract void deposit(double money);

    /**
     * Javadoc.
     */
    public String getTransactionHistory() {
        String s = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (Transaction transaction : transactionList) {
            s = s + "\n" + transaction.getTransactionSummary();
        }
        return s;
    }

    /**
     * Javadoc.
     */
    public void addTransaction(Transaction a) {
        transactionList.add(a);
    }

    /**
     * Javadoc.
     */
    public boolean equals(Object o) {
        if (this.accountNumber == ((Account) o).accountNumber) {
            return true;
        }
        return false;
    }
}
