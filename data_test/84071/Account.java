import java.util.ArrayList;
import java.util.List;

/**
 * abstract class Account.
 */
public abstract class Account {

    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * constructor.
     */
    public Account() {

    }

    /**
     * constructor.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * getter.
     * @return .
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * getter.
     * @return .
     */
    public double getBalance() {
        return balance;
    }

    /**
     * abstract method withdraw.
     * @param amount .
     */
    public abstract void withdraw(double amount);

    /**
     * abstract method deposit.
     * @param amount .
     */
    public abstract void deposit(double amount);

    /**
     * doWithdrawing.
     * @param amount .
     * @throws InsufficientFundsException .
     */
    public void doWithdrawing(double amount)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
        if (balance < amount) {
            throw new InsufficientFundsException(amount);
        }
        if (this instanceof SavingsAccount) {
            if (balance - amount < 5000) {
                throw new InvalidFundingAmountException(amount);
            }
            if (amount > 1000) {
                throw new InsufficientFundsException(amount);
            }
        }
    }

    /**
     * doDepositing.
     * @param amount .
     * @throws InsufficientFundsException .
     */
    public void doDepositing(double amount)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
    }

    /**
     * getter.
     * @return .
     */
    public String getTransactionHistory() {
        StringBuilder result =
                new StringBuilder("Lịch sử giao dịch của tài khoản "
                + accountNumber + ":\n");
        for (Transaction transaction : transactionList) {
            result.append(transaction.getTransactionSummary())
                    .append("\n")
            ;
        }
        return result.toString().trim();
    }

    /**
     * addTransaction.
     * @param transaction .
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * equals.
     * @param o .
     * @return .
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }

}