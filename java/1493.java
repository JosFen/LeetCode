class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, k = 1;
        while (r < nums.length) {
            if (nums[r] == 0) k--;
            if (k < 0) k += 1 - nums[l++];

            r++;
        }

        return r - l - 1;
    }
}
