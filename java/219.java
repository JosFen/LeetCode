class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // create a set to store at most k unique elements 
        Set<Integer> set = new HashSet<>();
        
        // iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // if the set already contains the current element,
            // it means a duplicate exists
            if (!set.add(nums[i])) {
                return true;
            }
            
            // if the set size is greater than k,
            // remove the element that first-in in the set
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
