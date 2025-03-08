// Import your library
// Do not change the name of the Solution class
public class Solution {
    /** Day so fibonacci.*/
    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (n >= 93) {
            return Long.MAX_VALUE;
        }
        long a = 0;
        long b = 1;
        long c = 1;
        for (long i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            if (c >= Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        }
        return c;
    }


}