package buggy_code;

public class GcdWrongIf2 {
    public static int gcd(int a, int b) {
        if(a < b) {
            return b;
        }
        while (b != 0) {
            if ( a > b) {
                a = a -b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
