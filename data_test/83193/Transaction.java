/**
 * Created by CCNE on 03/12/2020.
 */
public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = -1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = -2;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * javadoc.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * javadoc.
     */
    private String getTransactionTypeString(int type) {
        String ret = "";
        switch (type) {
            case (1):
                ret = "Nạp tiền vãng lai";
                break;
            case (-1):
                ret = "Rút tiền vãng lai";
                break;
            case (2):
                ret = "Nạp tiền tiết kiệm";
                break;
            default:
                ret = "Rút tiền tiết kiệm";
        }
        return ret;
    }

    /**
     * javadoc.
     */
    public String getTransactionSummary() {
        String ret = "- Kiểu giao dịch: " + getTransactionTypeString(type) + ". ";
        ret += String.format("Số dư ban đầu: $%.2f. ", initialBalance);
        ret += String.format("Số tiền: $%.2f. ", amount);
        ret += String.format("Số dư cuối: $%.2f.", finalBalance);
        return ret;
    }
}
 