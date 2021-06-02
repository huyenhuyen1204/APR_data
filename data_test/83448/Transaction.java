import java.text.DecimalFormat;
import java.util.ArrayList;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private static final String[] typeToString =
            {"Nạp tiền vãng lai",
                    "Rút tiền vãng lai",
                    "Nạp tiền tiết kiệm",
                    "Rút tiền tiết kiệm"};

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public Transaction() {

    }

    /**
     * create an instance.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    public String getTransactionTypeString() {
        return typeToString[type];
    }

    /**
     * get transaction summary.
     */
    public String getTransactionSummary() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return "- Kiểu giao dịch: " + getTransactionTypeString()
                + ". Số dư ban đầu: $" + decimalFormat.format(initialBalance)
                + ". Số tiền: $" + decimalFormat.format(amount)
                + ". Số dư cuối: $" + decimalFormat.format(finalBalance) + ".";
    }
}
 