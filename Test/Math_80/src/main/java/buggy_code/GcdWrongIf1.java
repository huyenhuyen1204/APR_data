package buggy_code;

public class GcdWrongIf1 {
    public static int gcd(int a, int b) {
        if(a == 0 && b == 0) { //a == 0
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
