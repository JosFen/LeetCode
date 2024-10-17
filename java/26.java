class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int  l = 0, r = 1;

        while (r < nums.length) {
            if (nums[r] != nums[l]) nums[++l] = nums[r];
            r++;
        } 
        return l+1;
    }
}
