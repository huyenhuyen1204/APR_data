//package buggy_code;
//
//import junit.framework.TestCase;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class GcdNoExitTest extends TestCase {
//    @Test
//    public void test1 () {
//        Assert.assertEquals(GcdNoExit.gcd(0, 0), 0);
//    }
//
//    @Test
//    public void test2 () {
//        Assert.assertEquals(GcdNoExit.gcd(0, 10), 10);
//    }
//
//    @Test
//    public void test3 () {
//        Assert.assertEquals(GcdNoExit.gcd(10, 0), 10);
//    }
//
//    @Test
//    public void test5 () {
//        Assert.assertEquals(GcdNoExit.gcd(10, 15), 5);
//    }
//
//    @Test
//    public void test6 () {
//        Assert.assertEquals(GcdNoExit.gcd(15, 10), 5);
//    }
//}