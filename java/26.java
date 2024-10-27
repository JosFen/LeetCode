class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int l = 1, r = 1;

        while (r < nums.length) {
            if (nums[r] != nums[r-1]) nums[l++] = nums[r];
            r++;
        }
        return l;
    }
}
