class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int l = 1;
        int r = x;

        while (l < r) {
            int m = l + (r - l) / 2; // Use this to avoid potential overflow
            if (m > x / m) {
                r = m; // If m*m > x, adjust the right boundary
            } else {
                l = m + 1; // If m*m <= x, adjust the left boundary
            }
        }

        return l - 1; // Return l - 1 because l is now one past the answer
    }
}
