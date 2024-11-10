class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) return m;

            // Left part is sorted
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1; // Target is in the left half
                } else {
                    l = m + 1; // Target is in the right half
                }
            } 
            // Right part is sorted
            else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1; // Target is in the right half
                } else {
                    r = m - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }
}
