// Import your library
// Do not change the name of the Solution class
public class Solution {
    /**Type your main code here. */
    private int numerator;
    private int denominator = 1;

    /**getNumerator.*/
    public int getNumerator() {
        return numerator;
    }

    /**getDenominator.*/
    public int getDenominator() {
        return denominator;
    }

    /**setNumerator.*/
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**setDenominator.*/
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**Constructor.*/
    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**Tinh uoc chung lon nhat.*/
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**Tinh boi chung nho nhat.*/
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**Rut gon phan so.*/
    public Solution reduce() {
        int n = gcd(numerator, denominator);
        this.numerator = numerator / n;
        this.denominator = denominator / n;
        if (this.denominator < 0) {
            this.denominator *= (-1);
            this.numerator *= (-1);
        }
        return this;
    }

    /**Tinh tong.*/
    public Solution add(Solution other) {
        int tmp = lcm(this.denominator, other.denominator);
        this.numerator = this.numerator * (tmp / this.denominator);
        other.numerator = other.numerator * (tmp / other.denominator);
        this.denominator = tmp;
        this.numerator += other.numerator;
        return this;
    }

    /**Tinh hieu.*/
    public Solution subtract(Solution other) {
        int tmp = lcm(this.denominator, other.denominator);
        this.numerator = this.numerator * (tmp / this.denominator);
        other.numerator = other.numerator * (tmp / other.denominator);
        this.denominator = tmp;
        this.numerator -= other.numerator;
        return this;
    }

    /**Nhan.*/
    public Solution multiply(Solution other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return this;
    }

    /**Chia.*/
    public Solution divide(Solution other) {
        if (other.numerator == 0) {
            return this;
        }
        int tmpnum = other.numerator;
        int tmpden = other.denominator;
        other.setDenominator(tmpnum);
        other.setNumerator(tmpden);
        return this.multiply(other);
    }

    /**So sanh phan so.*/
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            this.reduce();
            other.reduce();
            return this.numerator == other.numerator && this.denominator == other.denominator;
        } else {
            return false;
        }
    }
}  