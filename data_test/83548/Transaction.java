import java.text.DecimalFormat;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Yes.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Yes.
     */
    private String getTransactionTypeString(int t) {
        if (t == TYPE_DEPOSIT_CHECKING) {
            return "Nạp tiền vãng lai";
        }
        if (t == TYPE_WITHDRAW_CHECKING) {
            return "Rút tiền vãng lai";
        }
        if (t == TYPE_DEPOSIT_SAVINGS) {
            return "Nạp tiền tiết kiệm";
        }
        return "Rút tiền tiết kiệm";
    }

    /**
     * Yes.
     */
    public String getTransactionSummary() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "- Kiểu giao dịch: " + getTransactionTypeString(type) + ". Số dư ban đầu: $"
                + df.format(initialBalance) + ". Số tiền: $"
                + df.format(amount) + ". Số dư cuối: $"
                + df.format(finalBalance) + ".";
    }
}
 