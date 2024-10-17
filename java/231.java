// O(1) bit counting, or n & (n-1) == 0
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n >= 0 && Integer.bitCount(n) == 1;
    }
}

//Recursion O(logn)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        else if (n <= 0 || n % 2 == 1) return false;
        else return isPowerOfTwo(n/2); 
    }
}
