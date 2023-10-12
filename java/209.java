class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;

        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= target) {
                if (r-l < minLen) minLen = r-l;
                sum -= nums[l++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
