import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    private long accountNumber;
    private double balance;
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

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Withdraw money from account.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (balance < amount) {
            throw new InsufficientFundsException(amount);
        } else if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance -= amount;
        }
    }

    /**
     * Deposit money from account.
     */
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    /**
     * Abstract deposit for sub class.
     */
    public abstract void deposit(double amount);

    /**
     * Abstract withdraw fro sub class.
     */
    public abstract void withdraw(double amount);

    /**
     * Add transaction to transaction list.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Get all transaction.
     */
    public String getTransactionHistory() {
        StringBuilder res = new StringBuilder(String.format(
                "Lịch sử giao dịch của tài khoản %d: ", accountNumber
        ));
        for (Transaction transaction : transactionList) {
            res.append("\n");
            res.append(transaction.getTransactionSummary());
        }
        return res.toString();
    }

    /**
     * Override equals fro removal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            return ((Account) obj).getAccountNumber() == accountNumber;
        }
        return false;
    }
}
