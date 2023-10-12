class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;

        while (i < k) {
            sum += nums[i];
            i++;
        }
        int c_sum = sum;

        while (i < nums.length) {
            c_sum += (nums[i] - nums[i-k]);
            if (c_sum > sum) sum = c_sum;
            i++;
        }

        return (double)sum/k;
    }
}
