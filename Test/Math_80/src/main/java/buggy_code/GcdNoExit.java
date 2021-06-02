package buggy_code;

public class GcdNoExit {
    public static int gcd(int a, int b) {
        if(a == 0 ) {
           // return b;
        }
        while (a != 0) { //b!=0
            if ( a > b) {
                a = a -b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
