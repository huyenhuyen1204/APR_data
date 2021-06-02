import java.text.DecimalFormat;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Get type of transaction.
     */
    private String getTransactionTypeString(int type) {
        switch (type) {
            case 1:
                return "Nạp tiền vãng lai";
            case 2:
                return "Rút tiền vãng lai";
            case 3:
                return "Nạp tiền tiết kiệm";
            default:
                return "Rút tiền tiết kiệm";
        }
    }

    /**
     * Get summary of transaction.
     */
    public String getTransactionSummary() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return "- Kiểu giao dịch: " + getTransactionTypeString(type) + ". Số dư ban đầu: $"
                + decimalFormat.format(initialBalance) + ". Số tiền: $"
                + decimalFormat.format(amount) + ". Số dư cuối: $"
                + decimalFormat.format(finalBalance) + ".";
    }
}