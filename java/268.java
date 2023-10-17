class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int result = len * (len + 1) / 2;

        for (int i : nums) {
            result -= i;
        }
        return result;
    }
}
