import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();
    public int typeAccountToInt = 0;
    public int maxWithdraw = 1000000000;
    public int minBalance = 0;
    public Account() {
        accountNumber = 0;
        balance = 0;
    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double b);

    public abstract void deposit(double b);

    public String getTransactionHistory() {
        String res = "Lịch sử giao dịch của tài khoản " + accountNumber +
                ": \n";
        for(int i = 0; i < transactionList.size(); i++) {
            res = res + transactionList.get(i).getTransactionSummary();
            if(i < transactionList.size() - 1) {
                res = res + "\n";
            }
        }
        return res;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account acc = (Account) obj;
        return this.accountNumber == acc.accountNumber;
    }

    public void doDepositing(double b) throws BankException {
        if (b < 0) {
            throw new InvalidFundingAmountException(b);
        }
        transactionList.add(new Transaction(typeAccountToInt, b, balance, balance + b));
        balance += b;
    }

    public void doWithdrawing(double b) throws BankException {
        if (b > maxWithdraw || b > balance || balance - b < minBalance) {
            throw new InsufficientFundsException(b);
        }
        transactionList.add(new Transaction(typeAccountToInt + 1, b, balance, balance + b));
        balance -= b;
    }
}
 