import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * Yes.
     */
    public Account() {

    }

    /**
     * Yes.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Yes.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Yes.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Yes.
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
     * Yes.
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
     * Yes.
     */
    public abstract void withdraw(double x);

    /**
     * Yes.
     */
    public abstract void deposit(double x);

    /**
     * Yes.
     */
    public void addTransaction(Transaction a) {
        transactionList.add(a);
    }

    /**
     * Yes.
     */
    public String getTransactionHistory() {
        String s = "Lịch sử giao dịch của tài khoản "
                + accountNumber
                + ":";
        for (Transaction transaction : transactionList) {
            s = s
                    + "\n"
                    + transaction.getTransactionSummary();
        }
        return s;
    }

    /**
     * Yes.
     */
    public boolean equals(Object obj) {
        if (this.accountNumber == ((Account) obj).accountNumber) {
            return true;
        }
        return false;
    }
}
 