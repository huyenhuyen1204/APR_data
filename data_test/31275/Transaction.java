public class Transaction {
    private String operation; //Thuộc tính tên loại giao dịch operation có kiểu là String
    private double amount;    //Thuộc tính số tiền giao dịch amount có kiểu là double
    private double balance;   //Thuộc tính số dư còn lại trong tài khoản balance có kiểu là double

//Khai báo hai biến hằng có sử dụng static ,final: DEPOSIT , WITHDRAW đều có kiểu là String và mức truy nhập là public.
    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAW = "WITHDRAW";

//Thêm phương thức khởi tạo có ba tham số (operation, amount, balance)
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
