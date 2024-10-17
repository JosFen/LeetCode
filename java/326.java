// Iteration:
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;

        return (n == 1);
    }
}

// O(1): 3^19 is the largest power of 3 within a 32-bit signed integer
class Solution {
  public boolean isPowerOfThree(int n) {
    return n > 0 && Math.pow(3, 19) % n == 0;
  }
}
