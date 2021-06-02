package buggy_code;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GcdWrongIf2Test extends TestCase {
    @Test
    public void test1 () {
        Assert.assertEquals(GcdWrongIf2.gcd(0, 0), 0);
    }

    @Test
    public void test2 () {
        Assert.assertEquals(GcdWrongIf2.gcd(0, 10), 10);
    }

    @Test
    public void test3 () {
        Assert.assertEquals(GcdWrongIf2.gcd(10, 0), 10);
    }

    @Test
    public void test5 () {
        Assert.assertEquals(GcdWrongIf2.gcd(10, 15), 5);
    }

    @Test
    public void test6 () {
        Assert.assertEquals(GcdWrongIf2.gcd(15, 10), 5);
    }
}