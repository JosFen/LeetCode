class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) return result;

        int idx = 0;
        for (int i : nums) {
            int pos_i = Math.abs(i);
            idx = pos_i - 1;
            if (nums[idx] < 0) result.add(pos_i);
            else nums[idx] *= -1;
        }

        return result;
    }
}
