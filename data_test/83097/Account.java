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
     * Do withdrawing.
     */
    public void doWithdrawing(double amount) throws InsufficientFundsException {
        if (amount <= 0 || amount > balance)
            throw new InsufficientFundsException(amount);
        balance -= amount;
    }

    /**
     * Do depositing.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount <= 0)
            throw new InvalidFundingAmountException(amount);
        balance += amount;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * Get transaction history.
     */
    public String getTransactionHistory() {
        StringBuilder history = new StringBuilder("Lịch sử giao dịch của tài khoản ");
        history.append(accountNumber).append(":");
        transactionList.forEach(n -> history.append('\n').append(n.getTransactionSummary()));
        return history.toString();
    }

    public void addTransaction(Transaction trans) {
        transactionList.add(trans);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Account && this.accountNumber == ((Account) obj).accountNumber;
    }
}

