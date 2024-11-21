// O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int partialSum = 0;

        for (int num : nums) {
            partialSum = Math.max(num, partialSum + num);
            maxSum = Math.max(maxSum, partialSum);
        }
        return maxSum;
    }
}
