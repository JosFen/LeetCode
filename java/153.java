class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return nums[0]; // if rotated and not the original array, left most num will always be larger than the rightmost number

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= nums[r]) r = m; //e.g., 7 6 0 1 2 3 4 5, from min to rightmost is ascending, so ignore the right subarray beyong middle number
            else l = m + 1; // peak/max number in between m and r, ignore left subarray before m
        }
        return nums[l];
    }
}

