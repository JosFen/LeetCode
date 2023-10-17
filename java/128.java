class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> s = new HashSet<>();
        for (int i : nums) s.add(i);

        int result = 0;
        for (int i : nums) {
            if (!s.contains(i - 1)) {
                int count = 1;
                int nextNum = i + 1;
                while (s.contains(nextNum)){
                    count++;
                    nextNum++;
                }
                result = Math.max(result, count);
            }
        }

        return result;
    }
}
