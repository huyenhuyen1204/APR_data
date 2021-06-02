public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_CHECKING = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor.
     */
    public Transaction(int type, double amount,
                       double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Get transaction type as string for conversion.
     */
    public String getTransactionTypeString(int type) {
        String res = "";
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                res = "Nạp tiền vãng lai";
                break;
            case TYPE_DEPOSIT_SAVINGS:
                res = "Nạp tiền tiết kiệm";
                break;
            case TYPE_WITHDRAW_CHECKING:
                res = "Rút tiền vãng lai";
                break;
            case TYPE_WITHDRAW_SAVINGS:
                res = "Rút tiền tiết kiệm";
                break;
            default:
                res = "";
                break;
        }
        return res;
    }

    /**
     * Return all transaction as string.
     */
    public String getTransactionSummary() {
        return String.format("- Kiểu giao dịch: %s. " +
                        "Số dư ban đầu: $%.2f. " +
                        "Số tiền: $%.2f. " +
                        "Số dư cuối: $%.2f.",
                this.getTransactionTypeString(type),
                this.initialBalance,
                this.amount,
                this.finalBalance);
    }
}
