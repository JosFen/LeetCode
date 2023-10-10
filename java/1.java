/** 2ND VERSION: */ 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (numMap.containsKey(x)) {
                return new int[]{numMap.get(x), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}


/** 1ST VERSION: */ 
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int sortedNums[] = nums.clone();
//         Arrays.sort(sortedNums);

//         int lp = 0;
//         int rp = sortedNums.length - 1;

//         while (lp < rp) {
//             if (sortedNums[lp] + sortedNums[rp] == target) {
//                 break;
//             }
//             else if (sortedNums[lp] + sortedNums[rp] < target) {
//                 lp++;
//             } 
//             else {
//                 rp--;
//             }
//         }

//         int output[] = {-1, -1};

//         for (int i = 0; i < nums.length; i++) {
//             if (sortedNums[lp] == nums[i] && output[0] == -1) {
//                 output[0] = i;
//             }
//             if (sortedNums[rp] == nums[i]) {
//                 if(sortedNums[lp] == sortedNums[rp] && output[0] == -1) {
//                     continue;
//                 }
//                 output[1] = i;
//             }
//         }
//         return output;
//     }
// }
