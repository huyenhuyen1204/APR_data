import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 03/12/2020.
 */
public abstract class Account {
    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList;
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    /**
     * javadoc.
     */
    public Account() {
        transactionList = new ArrayList<Transaction>();
    }

    /**
     * javadoc.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionList = new ArrayList<Transaction>();
    }

    /**
     * javadoc.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * javadoc.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * javadoc.
     */
    public abstract void deposit(double number);

    /**
     * javadoc.
     */
    public abstract void withdraw(double number);

    /**
     * javadoc.
     */
    public void doDepositing(double number) throws BankException {
        if (number < 0) {
            throw new InvalidFundingAmountException(number);
        } else {
            balance += number;
        }
    }

    /**
     * javadoc.
     */
    public void doWithdrawing(double number) throws BankException {
        if (number < 0) {
            throw new InvalidFundingAmountException(number);
        } else if (number > balance) {
            throw new InsufficientFundsException(number);
        } else {
            balance -= number;
        }
    }

    /**
     * javadoc.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * javadoc.
     */
    public String getTransactionHistory() {
        String ret = "Lịch sử giao dịch của tài khoản " + accountNumber + ":\n";
        for (int i = 0; i < transactionList.size(); ++i) {
            Transaction transaction = transactionList.get(i);
            ret += transaction.getTransactionSummary();
            if (i < transactionList.size() - 1) {
                ret += "\n";
            }
        }
        return ret;
    }


    /**
     * javadoc.
     */
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        return (other.getAccountNumber() == this.getAccountNumber());
    }
}

 