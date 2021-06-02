package buggy_code;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GcdWrongPrintTest extends TestCase {
    @Test
    public void test1 () {
        Assert.assertEquals(GcdWrongPrint.gcd(0, 0), 0);
    }

    @Test
    public void test2 () {
        Assert.assertEquals(GcdWrongPrint.gcd(0, 10), 10);
    }

    @Test
    public void test3 () {
        Assert.assertEquals(GcdWrongPrint.gcd(10, 0), 10);
    }

    @Test
    public void test5 () {
        Assert.assertEquals(GcdWrongPrint.gcd(10, 15), 5);
    }

    @Test
    public void test6 () {
        Assert.assertEquals(GcdWrongPrint.gcd(15, 10), 5);
    }
}