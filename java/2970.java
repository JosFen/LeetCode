class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 3;

        int count = 1; // remove all elements;
        
        // increasing prefix subarray :
        int l = 0;
        while ((l < n-1) && (nums[l] < nums[l+1])) l++; // find the longest prefix subarray with length l+1
        count += (l + 1); // keep prefix subarray length from 1 to l+1

        // increasing suffix subarray:
        int r = n - 1;
        while (r > 0 && nums[r] > nums[r-1]) r--; // find the longest suffix subarray with length n-r
        count += (n - r); // keep suffix subarray length from 1 to n-r 

        // if prefix subarray overlaps with suffix subarray => the whole array is ascending:
        if (l >= r) return n*(n+1)/2;

        // remove middle subarray while keep element(s) in prefix and suffix if prefix < suffix:
        l = 0; // start left pointer from beginning, keep right pointer at the start of suffix
        while (l < r && r < n) {
            if (nums[l] < nums[r]) { // elements in prefix < the 1st/smallest element of suffix
                count += (n - r); // keep all current prefix elements (till nums[l]), and keep suffix subarray length from 1 to n-r 

                if (l < n-1 && nums[l] < nums[l+1]) l++; // continue only if the prefix subarray is ascending
                else break; // nums[l] >= nums[l+1], the prefix is not ascending and could not be considered, and the case reverts to find the longest ascending suffix
            }
            else r++; // move to larger number in the suffix
        }
        return count;
    }
}
