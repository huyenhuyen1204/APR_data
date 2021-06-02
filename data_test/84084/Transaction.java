/**
 * class Transaction.
 */
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
     * constructor.
     * @param type .
     * @param amount .
     * @param initialBalance .
     * @param finalBalance .
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * getter.
     * @param type .
     * @return .
     */
    private String getTransactionType(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "";
        }
    }

    /**
     * getter .
     * @return .
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: "
                + getTransactionType(type)
                + ". Số dư ban đầu: $"
                + String.format("%.2f", initialBalance)
                + ". Số tiền: $"
                + String.format("%.2f", amount)
                + ". Số dư cuối: $"
                + String.format("%.2f", finalBalance) + ".";
    }
}
