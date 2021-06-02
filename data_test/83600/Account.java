import java.util.ArrayList;
import java.util.List;


public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * Functions.
     */
    public Account() {
    }

    /**
     * Functions.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Functions.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Functions.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Functions.
     */
    public void doWithdrawing(double money) throws InvalidFundingAmountException,
            InsufficientFundsException {
        if (money < 0) {
            throw new InvalidFundingAmountException(money);
        }
        if (money > getBalance()) {
            throw new InsufficientFundsException(money);
        }
        balance -= money;
    }

    /**
     * Functions.
     */
    public void doDepositing(double money) throws InvalidFundingAmountException {
        if (money < 0) {
            throw new InvalidFundingAmountException(money);
        }
        balance += money;
    }

    /**
     * Functions.
     */
    public abstract void withdraw(double money);

    /**
     * Functions.
     */
    public abstract void deposit(double money);

    /**
     * Functions.
     */
    public String getTransactionHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");

        for (Transaction transaction : transactionList) {
            stringBuilder.append(transaction.getTransactionSummary());
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Functions.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Functions.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return account.accountNumber == this.accountNumber;

        }
        return false;
    }
}
