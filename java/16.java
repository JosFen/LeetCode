class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return target;
                else if (sum < target) l++;
                else r--;
                
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }
}
