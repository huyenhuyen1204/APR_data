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
     * cmt.
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
     * cmt.
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
     * cmt.
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

    public abstract void withdraw(double money);

    public abstract void deposit(double money);

    /**
     * cmt.
     */
    public String getTransactionHistory() {
        String s = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (Transaction transaction : transactionList) {
            s = s + "\n" + transaction.getTransactionSummary();
        }
        return s;
    }

    /**
     * cmt.
     */
    public void addTransaction(Transaction a) {
        transactionList.add(a);
    }

    /**
     * cmt.
     */
    public boolean equals(Object o) {
        if (this.accountNumber == ((Account) o).accountNumber) {
            return true;
        }
        return false;
    }
}
