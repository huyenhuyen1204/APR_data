import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Account() {}

    /**
     * Constructor with full parameters.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Getter for account Number.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Getter for balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Do With Drawing method.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }

        if (this instanceof SavingsAccount) {
            if (amount > 1000) {
                throw new InvalidFundingAmountException(amount);
            } else if (balance - amount < 5000) {
                throw new InsufficientFundsException(amount);
            }
        }

        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount, balance,
                    balance - amount);
        } else {
            transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, balance,
                    balance - amount);
        }
        transactionList.add(transaction);
        balance -= amount;
    }

    /**
     * Do Depositing method.
     */
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }

        Transaction transaction;
        if (this instanceof CheckingAccount) {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount, balance,
                    balance + amount);
        } else {
            transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, balance,
                    balance + amount);
        }
        transactionList.add(transaction);
        balance += amount;
    }

    /**
     * Abstract.
     */
    public abstract void withdraw(double balance);

    /**
     * Deposit.
     */
    public abstract void deposit(double balance);

    /**
     * Get history of transaction.
     */
    public String getTransactionHistory() {
        String res = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (int i = 0; i < transactionList.size(); ++i) {
            res += "\n";
            res += transactionList.get(i).getTransactionSummary();
        }
        return res;
    }

    /**
     * Add transaction.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Equals method.
     */
    @Override
    public boolean equals(Object o) {
        if (this.accountNumber == ((Account) o).accountNumber) {
            return true;
        }
        return false;
    }
}
