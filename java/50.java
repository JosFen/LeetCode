// Iteration:
class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        
        double result = 1;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        while (n != 0) {
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>>= 1;
        }

        return result;
    }
}


// Recursion:
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / myPow(x, -n);
        if (n % 2 == 1)  return x * myPow(x, n - 1);
        return myPow(x * x, n / 2);
    }
}
