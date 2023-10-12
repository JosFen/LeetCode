class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) k--;
            if (k < 0){
                // if nums[l] == 1, then keep the previous largest window size; else k++ for possible later expansion
                k += 1 - nums[l++];
            }
            r++;
        }

        return r - l;
    }
}

// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int count_ones = 0;
//         int maxFreq = 0, l = 0, res = 0;

//         for (int r = 0; r < nums.length; r++) {
//             if (nums[r] == 1) count_ones++;
//             maxFreq = Math.max(maxFreq, count_ones);

//             if (r - l + 1 - maxFreq > k){
//                 count_ones -= nums[l++];
//             }
//             res = Math.max(res, r-l+1);
//         }
//         return res;
//     }
// }
