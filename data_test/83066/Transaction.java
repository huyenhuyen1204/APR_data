//package banking;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;
    private Map<Integer, String> map = new HashMap<>();
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * constructer.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
        map.put(1, "Nạp tiền vãng lai");
        map.put(2, "Rút tiền vãng lai");
        map.put(3, "Nạp tiền tiết kiệm");
        map.put(4, "Rút tiền tiết kiệm");

    }

    private String getTransactionTypeString(int a) {
        return map.get(a);
    }

    /**
     *  return Transaction Sumary.
     */
    public String getTransactionSumary() {
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
