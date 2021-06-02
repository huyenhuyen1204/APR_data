import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * tt.
     */
    public Account() {

    }

    /**
     * tt.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * tt.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * tt.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * tt.
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
     * tt.
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
     * tt.
     */
    public abstract void withdraw(double money) ;

    /**
     * tt.
     */
    public abstract void deposit(double money) ;

    /**
     * tt.
     */
    public void addTransaction(Transaction tr) {
        transactionList.add(tr);
    }

    /**
     * tt.
     */
    public String getTransactionHistory() {
        String res = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (Transaction transaction : transactionList) {
            res = res + "\n" + transaction.getTransactionSummary();
        }
        return res;
    }

    /**
     * tt.
     */
    public boolean equals(Object o) {
        if(accountNumber == ((Account) o).accountNumber) {
            return true;
        }
        return false;
    }
}
