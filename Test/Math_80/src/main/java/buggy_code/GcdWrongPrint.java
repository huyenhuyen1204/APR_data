package buggy_code;

public class GcdWrongPrint {
    public static int gcd(int a, int b) {
        if(a == 0) {
            return a;
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

    public static void main(String[] args) {
        gcd(1, 2);
    }
}
