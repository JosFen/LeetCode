class Solution {
    private int searchHelper(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        
        int m = (l+r)/2;
        if (nums[m] == target) return m;
        if (nums[m] < target) return searchHelper(nums, target, m+1, r);
        else return searchHelper(nums, target, l, m-1);  
    }
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        return searchHelper(nums, target, l, r);
    }
}
