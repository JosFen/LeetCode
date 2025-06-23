// no DP: (Fibonacci?)
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// bottom-up DP: 
// Time & Space complexity: O(n)
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) cache[i] = cache[i-1] + cache[i-2];

        return cache[n];
    }
}

// DP (space optimized):
// Time complexity: O(n);  Space complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;
        int tmp = 0;

        for (int i = 3; i <= n; i++) {
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}

// Math:
// Time complexity: O(log n);  Space complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        double root_5 = Math.sqrt(5);
        double phi =  (1 + root_5) / 2;
      // (increment n) since the result is the (n+1)th Fibonacci number, 
      // as the first three are F(0) = 0, F(1) = 1, F(2) = 1, F(3) = 2:
        n++; 

        return (int) Math.round(( Math.pow(phi, n) - Math.pow(1 - phi, n) ) / root_5);
    }
}
