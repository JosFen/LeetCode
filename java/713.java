/** 2nd  */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1;
        int count = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (i - left) + 1;
        }
        
        return count;
    }
}


/** 1st Brute Force */
// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         int count = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] >= k) continue;
//             else count++;

//             int product = nums[i];
//             for (int j = i+1; j < nums.length; j++) {
//                 if (nums[j] >= k) break;
//                 product *= nums[j];
                
//                 if (product < k) count++;
//                 else break;
//             }
//         }
        
//         return count;
//     }
// }
