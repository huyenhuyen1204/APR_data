import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    public long accountNumber;
    public double balance;
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

    public void doWithdrawing(double num) throws InsufficientFundsException, InvalidFundingAmountException {
        if (this instanceof SavingsAccount) {
            if (num > 1000) {
                throw new InvalidFundingAmountException(num);
            }
            if (balance - num < 5000) {
                throw new InsufficientFundsException(balance);
            }
        }
        if (balance - num < 0) {
            throw new InsufficientFundsException(balance);
        }
        Transaction transaction = new Transaction(num, balance, balance - num);
        transactionList.add(transaction);
        balance = balance - num;
    }

    public void doDepositing(double num) throws InvalidFundingAmountException {
        if (num < 0) {
            throw new InvalidFundingAmountException(num);
        }
        Transaction transaction = new Transaction(num, balance, balance + num);
        transactionList.add(transaction);
        balance = balance + num;
    }

    public String getTransactionHistory() {
        StringBuilder ans = new StringBuilder();
        ans.append("Lịch sử giao dịch của tài khoản ").append(this.accountNumber).append(":").append("\n");
        for (Transaction transaction: transactionList) {
            ans.append(transaction.getTransactionSummary());
            ans.append("\n");
        }
        return String.valueOf(ans);
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public abstract void withdraw(double num);
    public abstract void deposit(double num);

    @Override
    public boolean equals(Object obj) {
        Account other = (Account) obj;
        return other.accountNumber == this.accountNumber;
    }
}