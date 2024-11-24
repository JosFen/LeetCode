// time & space complexity: O(2^n) 
class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    private int dfs(int[] nums, int i, int xorSum) {
        // Base case: if all elements are processed
        if (i == nums.length) return xorSum;

        int currNumInSet = dfs(nums, i + 1, nums[i] ^ xorSum);
        int currNumNotInSet = dfs(nums, i + 1, xorSum);

        return currNumInSet + currNumNotInSet;
    }
}

// time: O(n); space: O(1)
class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum |= nums[i];
        }
        sum <<= (nums.length - 1);
        return sum;
    }
   
}
