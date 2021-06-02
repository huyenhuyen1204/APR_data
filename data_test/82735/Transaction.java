/**
 * Created by CCNE on 02/12/2020.
 */
public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public Transaction(int type, double amount, double initialBalance
            , double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    private String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING: return "Nạp tiền vãng lãi";
            case TYPE_WITHDRAW_CHECKING: return "Rút tiền vãng lãi";
            case TYPE_DEPOSIT_SAVINGS: return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS: return "Rút tiền tiết kiệm";
        }
        return "";
    }

    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(type) + ". Số dư ban đầu "
                + initialBalance + ". Số tiền: " + amount + ". Số dư cuối: " + finalBalance;
    }
}
 