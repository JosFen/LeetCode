// Recursion O(2^n)
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1)+fib(n-2);
    }
}

// Iteration / DP O(n)
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int f = 0, s = 1;
        for (int i = 2; i <= n; i++){
            int sum = f + s;
            f = s;
            s = sum;
        }
        return s;
    }
}
