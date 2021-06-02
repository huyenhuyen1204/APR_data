//package transaction;
import net.bqc.oasis.junit.JavaReflection;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class MyTest {
    static Method depositMethod;
    static Method withdrawMethod;
    static Method addTransactionMethod;
    static Method printTransactionMethod;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeClass
    public static void init(){
        depositMethod = JavaReflection.getMethod(Account.class, "deposit", void.class, "", ""
        , double.class);
        withdrawMethod = JavaReflection.getMethod(Account.class, "withdraw", void.class, "", "",
                double.class);
        addTransactionMethod = JavaReflection.getMethod(Account.class, "addTransaction", void.class, "","",
                double.class, String.class);
        printTransactionMethod= JavaReflection.getMethod(Account.class, "printTransaction", void.class, "", "");

    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Them amount ngoai le
     */
    @Test
    public void testDeposit1(){
            Account account = new Account();
            Assert.assertNotNull(depositMethod);
            Assert.assertNotNull(addTransactionMethod);
            account.addTransaction(-1, "deposit");
            Assert.assertEquals("So tien ban nap vao khong hop le!", outContent.toString().trim());
    }

    /**
     * them amount
     */
    @Test
    public void testDeposit2(){
        Account account = new Account();
        Assert.assertNotNull(depositMethod);
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(1000.0, "deposit");
        account.printTransaction();
        Assert.assertEquals("Giao dich 1: Nap tien $1000.00. So du luc nay: $1000.00.", outContent.toString().trim());

    }

    /**
     * Rut tien ngoai le
     */
    @Test
    public void testWithdraw1(){
        Account account = new Account();
        Assert.assertNotNull(withdrawMethod);
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(1000.0, "deposit");
        account.addTransaction(-1, "withdraw");
        Assert.assertEquals("So tien ban rut ra khong hop le!", outContent.toString().trim());
        File file = new File("C:\\Users\\Dell\\Desktop\\APR_Test\\data_test\\85713\\Account.java");
//        String content = FileService.readFileToString(file.getAbsolutePath());
//        ArrayList<ClassNode> classNodes = JavaFileParser.parse(content);
//        System.out.println(classNodes.toString());
    }

    /**
     * Rut tien lon hon
     */
    @Test
    public void testWithdraw2(){
        Account account = new Account();
        Assert.assertNotNull(withdrawMethod);
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(1000.0, "deposit");
        account.addTransaction(5000, "withdraw");
        Assert.assertEquals("So tien ban rut vuot qua so du!", outContent.toString().trim());
    }

    /**
     * Rut tien lon hon
     */
    @Test
    public void testWithdraw3(){
        Account account = new Account();
        Assert.assertNotNull(withdrawMethod);
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(5000, "withdraw");
        Assert.assertEquals("So tien ban rut vuot qua so du!", outContent.toString().trim());
    }

    /**
     * Rut tien nho hon
     */
    @Test
    public void testWithdraw4(){
        Account account = new Account();
        Assert.assertNotNull(withdrawMethod);
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(1000.0, "deposit");
        account.addTransaction(500.0, "withdraw");
        account.printTransaction();
        Assert.assertEquals("Giao dich 1: Nap tien $1000.00. So du luc nay: $1000.00.\n" +
                "Giao dich 2: Rut tien $500.00. So du luc nay: $500.00.", outContent.toString().trim());
    }

    /**
     * Test print
     */
    @Test
    public void testPrintTransaction(){
        Account account = new Account();
        Assert.assertNotNull(printTransactionMethod);
        account.addTransaction(3000.6844,"deposit");
        account.addTransaction(3000,"deposit");
        account.addTransaction(1000,"withdraw");
        account.addTransaction(2000,"withdraw");
        account.printTransaction();
        Assert.assertEquals("Giao dich 1: Nap tien $3000.68. So du luc nay: $3000.68.\n" +
                "Giao dich 2: Nap tien $3000.00. So du luc nay: $6000.68.\n" +
                "Giao dich 3: Rut tien $1000.00. So du luc nay: $5000.68.\n" +
                "Giao dich 4: Rut tien $2000.00. So du luc nay: $3000.68.", outContent.toString().trim());
    }

    @Test
    public void testAddTransaction(){
        Account account = new Account();
        Assert.assertNotNull(addTransactionMethod);
        account.addTransaction(1000, "test");
        Assert.assertEquals("Yeu cau khong hop le!", outContent.toString().trim());
    }
}
