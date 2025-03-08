// Import your library
// Do not change the name of the Solution class
public class Solution {

    /** Uoc so chung lon nhat.*/
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        if (a == -1) {
            return 1;
        }
        return a;
    }
}