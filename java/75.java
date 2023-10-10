/** 1-pass */
class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int p = 0;
        while (p <= r) {
            if (nums[p] == 0) {
                nums[p] = nums[l];
                nums[l++] = 0;
            }
            else if (nums[p] == 2) {
                nums[p--] = nums[r]; // decement p to cancel with p increment
                nums[r--] = 2;
                
            }
            p++;
        }
    }
}


// /** 2-pass */
// class Solution {
//     public void sortColors(int[] nums) {
//         int wCount = 0;
//         int bCount = 0;
//         int pointer = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) nums[pointer++] = 0;
//             else if (nums[i] == 1) wCount++;
//             else bCount++;
//         }
        
//         int j = pointer;
//         while (j < wCount + pointer ) nums[j++] = 1;
//         while (j < nums.length) nums[j++] = 2;
//     }
// }
