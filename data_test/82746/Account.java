import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCNE on 02/12/2020.
 */
public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

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

    /** Withdraw. */
    public void doWithdrawing(double amount)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (balance - amount < 0) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }
    }

    /** Deposit. */
    public void doDepositing(double amount)
            throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /** Transaction history. */
    public String getTransactionHistory() {
        StringBuilder result = new StringBuilder(
                "Lịch sử giao dịch của tài khoản " + accountNumber + ":\n");
        for (Transaction transaction : transactionList) {
            result.append(transaction.getTransactionSummary()).append("\n");
        }
        return result.toString().trim();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            if (accountNumber == ((Account) obj).accountNumber) {
                return true;
            }
        }
        return false;
    }
}
 