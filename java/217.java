class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;

        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (!s.add(i)) return true;
        }
        return false;
    }
}


// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         if (nums.length == 1) return false;
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i+1]) return true;
//         }
//         return false;
//     }
// }
