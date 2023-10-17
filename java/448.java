class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 1) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            int index = Math.abs(i)-1;
            if (nums[index] > 0) nums[index] *= -1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) result.add(j+1);
        }

        return result;
    }
}
