// Boyer–Moore majority vote algorithm: O(n)
// https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count =0;

        for (int c : nums) {
            if (count == 0) candidate = c;
            count += (candidate == c) ? 1 : -1;
        }
        return candidate;
    }
}

// Sorting: O(nlogn)
public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
