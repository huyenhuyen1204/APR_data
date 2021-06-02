//package banking;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private Map<Integer, String> map = new HashMap<>();
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Functions.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
        map.put(0, "Nạp tiền vãng lai");
        map.put(1, "Rút tiền vãng lai");
        map.put(2, "Nạp tiền tiết kiệm");
        map.put(3, "Rút tiền tiết kiệm");
    }

    private String getTransactionTypeString(int a) {
        return map.get(a);
    }

    /**
     * Functions.
     */
    public String getTransactionSummary() {
        StringBuilder res = new StringBuilder();
        res.append("- Kiểu giao dịch: ")
                .append(getTransactionTypeString(type))
                .append(". Số dư ban đầu: $").append(String.format("%.2f", initialBalance))
                .append(". Số tiền: $").append(String.format("%.2f", amount))
                .append(". Số dư cuối: $").append(String.format("%.2f", finalBalance))
                .append(".\n");

        return res.toString();
    }
}
