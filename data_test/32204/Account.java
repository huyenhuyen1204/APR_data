import java.util.ArrayList;

public class Account {
    //    Thêm các thuộc tính với mức truy nhập private gồm:
//    Thuộc tính thông tin về số dư tài khoản ngân hàng balance, có kiểu là double
//    Một danh sách các giao dịch (sử dụng ArrayList) để theo dõi các thao tác nạp tiền, rút tiền ( vì lịch sử giao dịch chỉ được sử dụng ở phương thức printTransaction()).
//    Thêm hai phương thức deposit, withdraw với mức truy nhập private (vì hai phương thức này sẽ được gọi và sử dụng qua phương thức public addTransaction):
//    Tạo phương thức có một tham số deposit để nạp tiền vào tài khoản, có kiểu trả về void và có tham số truyền vào là số tiền giao dịch amount (có kiểu double).
//    Số tiền nạp vào phải lớn hơn 0, ngược lại in ra xuất chuẩn: So tien ban nap vao khong hop le!
//    Tương tự như deposit ta tạo phương thức có một tham số withdraw để rút tiền từ tài khoản, có kiểu trả về void và có tham số truyền vào là số tiền giao dịch amount (có kiểu double).
//    Số tiền rút ra phải lớn hơn 0, ngược lại in ra xuất chuẩn So tien ban rut ra khong hop le!
//    Nếu số tiền rút lớn hơn số dư, in ra xuất chuẩn So tien ban rut vuot qua so du!
//    Thêm phương thức addTransaction để thêm một giao dịch vào danh sách các giao dịch:
//    Có kiểu trả về void
//    Có hai tham số truyền vào là:
//    amount- số tiền giao dịch (kiểu double)
//    operation - tên loại giao dịch (kiểu String, có hai loại giao dịch DEPOSIT, WITHDRAW đã được định nghĩa trong Transaction).
//    Nếu loại giao dịch truyền vào operation khác hai loại đã được định nghĩa, in ra xuất chuẩn: Yeu cau khong hop le!
//    Tạo phương thức không có tham số printTransaction() để đưa ra các dòng xuất chuẩn thông tin về tất cả các giao dịch của mỗi tài khoản, có kiểu trả về void, mức truy nhập public. Số tiền in ra được làm tròn hai chữ số thập phân sau dấu phẩu . Ví dụ:
    private double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;

        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }

    }

    public void addTransaction(double amount, String operation) {
        if (Transaction.DEPOSIT == operation) {
            this.deposit(amount);
            Transaction tr = new Transaction("Nap tien", amount, this.balance);
            transactions.add(tr);
        } else if (Transaction.WITHDRAW == operation) {
            this.withdraw(amount);
            Transaction tr = new Transaction("Rut tien", amount, this.balance);
            transactions.add(tr);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        int i = 1;
        for (Transaction item : transactions) {
            System.out.printf("Giao dich " + i + ": " + item.getOperation() + " $%.2f. So du luc nay: $%.2f.\n", item.getAmount(), item.getBalance());
            //System.out.println("Giao dich " + i + ": " + item.getOperation() + " $" + (double)Math.round( item.getAmount() * 100)/100 + ". "  + "So du luc nay: $" + (double)Math.round( item.getBalance() * 100)/100 + ".");
            i++;
        }
    }


}
