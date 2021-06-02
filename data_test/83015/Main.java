import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        bank.readCustomerList(new FileInputStream("in.inp"));
        System.out.print(bank.getCustomersInfoByNameOrder());
    }
}
