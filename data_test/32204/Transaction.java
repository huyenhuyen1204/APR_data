public class Transaction {
    //    Thêm các thuộc tính với mức truy nhập private gồm :
//    Thuộc tính tên loại giao dịch operation có kiểu là String
//    Thuộc tính số tiền giao dịch amount có kiểu là double
//    Thuộc tính số dư còn lại trong tài khoản balance có kiểu là double
//    Khai báo hai biến hằng có sử dụng static ,final: DEPOSIT , WITHDRAW đều có kiểu là String và mức truy nhập là public.
//    Thêm phương thức khởi tạo có ba tham số (operation, amount, balance)
//    Thêm phương thức getter/setter cho các thuộc tính.
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
