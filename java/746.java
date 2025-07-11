// Time & Space: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[n + 1];
        dp[n-1] = cost[n-1]; // dp[n] = 0 by default
        for (int i = n-2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}

// If cost array could be modified:
// Time: O(n) ; Space O(1) 
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        for (int i = n - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
