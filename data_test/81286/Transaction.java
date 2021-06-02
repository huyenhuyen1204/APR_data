public class Transaction {

    private String operation;
    private Double amount;
    private Double balance;
    public static final String DEPOSIT = "";
    public static final String WITHDRAW = "";

    /**
     * cmt.
     */
    public Transaction(String operation, Double amount, Double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * cmt.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * cmt.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * cmt.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * cmt.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * cmt.
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * cmt.
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * cmt.
     */
    public static String getDEPOSIT() {
        return DEPOSIT;
    }

    /**
     * cmt.
     */
    public static String getWITHDRAW() {
        return WITHDRAW;
    }
}

