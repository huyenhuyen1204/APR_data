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

    /**
     * kiem tra so tien rut va - tien.
     */
    public void doWithdrawing(double d) throws InvalidFundingAmountException,
            InsufficientFundsException {
        if (d < 0) {
            throw new InvalidFundingAmountException(d);
        }
        if (d > getBalance()) {
            throw new InsufficientFundsException(d);
        }

        balance -= d;
    }

    /**
     * kiem tra so tien gui va + tien.
     */
    public void doDepositing(double d) throws InvalidFundingAmountException {
        if (d < 0) {
            throw new InvalidFundingAmountException(d);
        }
        balance += d;
    }

    public abstract void withdraw(double d);

    public abstract void deposit(double d);

    /**
     *  return toan bo giao dich .
     */
    public String getTransactionHistory() {
        StringBuilder res = new StringBuilder();
        res.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");

        for (Transaction transaction : transactionList) {
            res.append(transaction.getTransactionSumary());
        }
        return res.toString().trim();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return account.accountNumber == accountNumber;

        }
        return false;
    }
}
