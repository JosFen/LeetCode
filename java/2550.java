class Solution {
    private static final int mod = 1_000_000_007; // return result modulo 10^9 + 7 if it is very large

    private long pow(long base, long n) {
        if (n == 0) return 1;
        if (n % 2 == 1) return base * pow(base, n-1) % mod;
        return pow(base * base % mod, n/2);
    }

    public int monkeyMove(int n) {
        final int result = (int) pow(2, n) - 2; // only 2 ways to avoid collision
        return (result < 0) ? result + mod : result;
    }
}
